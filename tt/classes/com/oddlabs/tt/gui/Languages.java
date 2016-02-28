package com.oddlabs.tt.gui;

import com.oddlabs.util.Quad;

public final strictfp class Languages {
	private final String[][] languages;
	private final boolean beta_mode;
	
	public Languages(boolean beta_mode) {
		this.beta_mode = beta_mode;
		if (beta_mode) {
			languages = new String[][]{{"da", "Dansk"}, {"en", "English"}, {"de", "Deutsch"}, {"es","Espa\u00F1ol"}, {"it", "Italiano"}};
		} else {
			languages = new String[][]{{"da", "Dansk"}, {"en", "English"}, {"de", "Deutsch"}, {"es","Espa\u00F1ol"}, {"it", "Italiano"}};
		}
	}

	public boolean hasLanguage(String language) {
            for (String[] language1 : languages) {
                if (language1[0].equals(language)) {
                    return true;
                }
            }
		return false;
	}
	
	public String[][] getLanguages() {
		return languages;
	}

	public Quad[] getFlags() {
		Quad[] flags;
		if (beta_mode) {
			flags = new Quad[]{Skin.getSkin().getFlagDa(), Skin.getSkin().getFlagEn(), Skin.getSkin().getFlagDe(), Skin.getSkin().getFlagEs(), Skin.getSkin().getFlagIt()};
		} else {
			flags = new Quad[]{Skin.getSkin().getFlagDa(), Skin.getSkin().getFlagEn(), Skin.getSkin().getFlagDe(), Skin.getSkin().getFlagEs(), Skin.getSkin().getFlagIt()};
		}
		return flags;
	}
}
