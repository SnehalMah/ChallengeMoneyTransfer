package com.db.awmd.challenge.service;

import java.math.BigDecimal;

public class TransferBalanceRequest {
	    private String fromAccountNumber;

	    private String toAccountNumber;

	    private BigDecimal amount;

	    public String getFromAccountNumber() {
			return fromAccountNumber;
		}

		public void setFromAccountNumber(String fromAccountNumber) {
			this.fromAccountNumber = fromAccountNumber;
		}

		public String getToAccountNumber() {
			return toAccountNumber;
		}

		public void setToAccountNumber(String toAccountNumber) {
			this.toAccountNumber = toAccountNumber;
		}

		public BigDecimal getAmount() {
			return amount;
		}

		public void setAmount(BigDecimal amount) {
			this.amount = amount;
		}


}
