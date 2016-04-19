package good;

import java.util.HashMap;

public class Pokemon {
	private String name;

	// This is not the best way to create the hierarchy
	// but this is just the least possible to demonstrate.
	public Pokemon(String name) {
		this.name = name;
	}

	public String getName() {
		java.util.Map<Class<? extends Pokemon>, String> fileNameMap = new HashMap<>();
		fileNameMap.put(MewTwo.class, "MewtwoSprite.png");

		return this.name;
	}
}
