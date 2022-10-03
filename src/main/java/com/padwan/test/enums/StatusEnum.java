package com.padwan.test.enums;

public enum StatusEnum {
	PADAWAN(1), JEDI(2), MESTREJEDI(3);

	private Integer numero;

	private StatusEnum(Integer numero) {
		this.numero = numero;
	}

	public Integer getNumero() {
		return numero;
	}

	public static StatusEnum toEnum(Integer numero) {
		if (numero == 0)
			return null;
		for (StatusEnum tipo : StatusEnum.values()) {
			if (numero == tipo.getNumero())
				return tipo;
		}
		throw new IllegalArgumentException("Número Enum inválido!");

	}
}
