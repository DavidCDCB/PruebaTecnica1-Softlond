package com.cdcb.pruebatecnica1_softlond.domain;

public class Account {
	private String numbarAccount;
	private double balance;
	private String typeAccount;
	private int userId;

	public static final String DDL = String.join("\n",
		"CREATE TABLE CUENTAS(",
		"ID INTEGER PRIMARY KEY AUTOINCREMENT,",
		"NUMERO_CUENTA TEXT NOT NULL UNIQUE,",
		"SALDO REAL NOT NULL,",
		"TIPO_CUENTA TEXT NOT NULL,",
		"ID_USUARIO INTEGER NOT NULL,",
		"FOREIGN KEY(ID_USUARIO) REFERENCES USUARIOS(ID)",
		");"
	);

	public Account() {}

	public Account(String numbarAccount, double balance, String typeAccount, int userId) {
		this.numbarAccount = numbarAccount;
		this.balance = balance;
		this.typeAccount = typeAccount;
		this.userId = userId;
	}

	public String getNumbarAccount() {
		return numbarAccount;
	}

	public void setNumbarAccount(String numbarAccount) {
		this.numbarAccount = numbarAccount;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getTypeAccount() {
		return typeAccount;
	}

	public void setTypeAccount(String typeAccount) {
		this.typeAccount = typeAccount;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public static String getDdl() {
		return DDL;
	}

	@Override
	public String toString() {
		return "Account [numbarAccount=" + numbarAccount + ", balance=" + balance + ", typeAccount=" + typeAccount
				+ ", userId=" + userId + "]";
	}


}
