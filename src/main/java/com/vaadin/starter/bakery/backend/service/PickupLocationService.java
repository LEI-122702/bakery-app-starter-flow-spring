package com.vaadin.starter.bakery.backend.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.vaadin.starter.bakery.backend.data.entity.PickupLocation;
import com.vaadin.starter.bakery.backend.data.entity.User;
import com.vaadin.starter.bakery.backend.repositories.PickupLocationRepository;

/**
 * Serviço responsável pela lógica de negócio relacionada com locais de levantamento (PickupLocation).
 * Permite realizar operações de pesquisa, contagem, criação e recuperação de entidades.
 */
@Service
public class PickupLocationService implements FilterableCrudService<PickupLocation> {

    /** Repositório para aceder aos dados dos locais de levantamento. */
    private final PickupLocationRepository pickupLocationRepository;

    /**
     * Construtor que injeta o repositório de PickupLocation.a
     *
     * @param pickupLocationRepository o repositório de locais de levantamento
     */
    @Autowired
    public PickupLocationService(PickupLocationRepository pickupLocationRepository) {
        this.pickupLocationRepository = pickupLocationRepository;
    }

    /**
     * Procura locais de levantamento que correspondam a um filtro textual (no nome).
     *
     * @param filter   filtro opcional a aplicar (parte do nome)
     * @param pageable parâmetros de paginação (página, tamanho, ordenação)
     * @return uma página com os resultados encontrados
     */
    public Page<PickupLocation> findAnyMatching(Optional<String> filter, Pageable pageable) {
        if (filter.isPresent()) {
            String repositoryFilter = "%" + filter.get() + "%";
            return pickupLocationRepository.findByNameLikeIgnoreCase(repositoryFilter, pageable);
        } else {
            return pickupLocationRepository.findAll(pageable);
        }
    }

    /**
     * Conta quantos locais de levantamento correspondem ao filtro fornecido.
     *
     * @param filter filtro opcional (parte do nome)
     * @return número total de correspondências
     */
    public long countAnyMatching(Optional<String> filter) {
        if (filter.isPresent()) {
            String repositoryFilter = "%" + filter.get() + "%";
            return pickupLocationRepository.countByNameLikeIgnoreCase(repositoryFilter);
        } else {
            return pickupLocationRepository.count();
        }
    }

    /**
     * Obtém o primeiro local de levantamento disponível (usado como padrão).
     *
     * @return um local de levantamento
     */
    public PickupLocation getDefault() {
        return findAnyMatching(Optional.empty(), PageRequest.of(0, 1)).iterator().next();
    }

    /**
     * Devolve o repositório associado à entidade PickupLocation.
     *
     * @return o JpaRepository correspondente
     */
    @Override
    public JpaRepository<PickupLocation, Long> getRepository() {
        return pickupLocationRepository;
    }

    /**
     * Cria uma nova instância de PickupLocation.
     *
     * @param currentUser o utilizador atual (não é usado aqui, mas faz parte do contrato da interface)
     * @return nova instância de PickupLocation
     */
    @Override
    public PickupLocation createNew(User currentUser) {
        return new PickupLocation();
    }
}

