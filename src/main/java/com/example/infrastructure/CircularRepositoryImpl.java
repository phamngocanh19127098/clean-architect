package com.example.infrastructure;

import com.example.domain.Circular;
import com.example.domain.Identity;
import com.example.infrastructure.entity.CircularEntity;
import com.example.domain.usecase.circular.CircularRepository;

import java.util.List;
import java.util.Optional;

public class CircularRepositoryImpl implements CircularRepository {
    private final   CircularJPARepository circularJPARepository;
    public CircularRepositoryImpl(CircularJPARepository circularJPARepository) {
        this.circularJPARepository = circularJPARepository;
    }
    @Override
    public Circular create(Circular circular) {
        CircularEntity circularEntity = new CircularEntity();
        circularEntity.setId(circularEntity.getId());
        circularEntity.setName(circularEntity.getName());
        circularEntity.setDescription(circularEntity.getDescription());
        circularJPARepository.save(circularEntity);
        return circular;
    }

    @Override
    public List<Circular> readAll() {
        return null;
    }

    @Override
    public Optional<Circular> readByIdentity(Identity identity) {

        Optional<CircularEntity> ce = circularJPARepository.findById(identity.getId());
        Optional<Circular> read = ce.map(t -> Circular.builder()
                .withId(Identity.of(t.getId()))
                .withName(t.getName())
                .withDescription(t.getDescription())
                .build());
        return read;
    }

    @Override
    public List<Circular> deleteAll() {
        return null;
    }

    @Override
    public Optional<Circular> deleteByIdentity(Identity identity) {
        return Optional.empty();
    }
}
