package com.example.dummyproject.model.entity.seconddb;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "vn_pay_record")
@Data
public class VNPayRecord {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "seq_no")	
	private Integer seqNo;

	@Column(name = "pd_no")	
	private String pdNo;
	
	@Column(name = "agnt_empno")	
	private String agntEmpno;
	
	@Column(name = "agnt_name")	
	private String agntName;
	
	@Column(name = "client_app")	
	private String clientApp;
	
	@Column(name = "total_amount")	
	private BigDecimal totalAmount;
	
	@Column(name = "pay_status")	
	private String payStatus;
	
	@Column(name = "result_code")	
	private String resultCode;
	
	@Column(name = "result_message")	
	private String resultMessage;
	
	@Column(name = "payment_id")	
	private String paymentId;
	
	@Column(name = "payment_date")	
	private Timestamp paymentDate;
	
	@Column(name = "update_date")	
	private Timestamp updateDate;
	
	@Column(name = "updated_core")
	private String updatedCore;
	
	@Column(name = "verify_result")
	private String verifyResult;
	
}
