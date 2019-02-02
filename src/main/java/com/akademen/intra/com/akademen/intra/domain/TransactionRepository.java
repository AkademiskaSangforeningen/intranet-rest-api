package com.akademen.intra.com.akademen.intra.domain;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface TransactionRepository  extends PagingAndSortingRepository<Transaction, String> {
}
