package com.example.dummyproject.repo.seconddb;

import com.example.dummyproject.model.entity.seconddb.VNPayRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VNPayRecordRepository extends JpaRepository<VNPayRecord, Integer> {

	void deleteByPaymentId(String paymentId);

	Optional<VNPayRecord> findByPaymentId(String paymentId);

	Optional<VNPayRecord> findFirstByPdNoAndAgntEmpnoOrderBySeqNoDesc(String pdNo, String agntEmpno);

}
