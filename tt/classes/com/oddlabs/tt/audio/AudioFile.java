package com.oddlabs.tt.audio;

import com.oddlabs.tt.resource.File;

public final strictfp class AudioFile extends File {
	public AudioFile(String location) {
		super(location);
	}

        @Override
	public Object newInstance() {
		return new Audio(this.getURL());
	}

        @Override
	public boolean equals(Object o) {
		if (!(o instanceof AudioFile))
			return false;
		return super.equals(o);
	}
}
