package com.lambdaschool.friendfinderbe.repository;

import com.lambdaschool.friendfinderbe.models.Quote;
import org.springframework.data.repository.CrudRepository;

public interface QuoteRepository extends CrudRepository<Quote, Long>
{

}
