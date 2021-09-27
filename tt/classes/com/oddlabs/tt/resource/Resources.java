package com.oddlabs.tt.resource;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Provides a cache of resources by their descriptors
 */
public final strictfp class Resources {
	private final static Map<ResourceDescriptor<?>, Object> loaded_resources = new ConcurrentHashMap<>();

	public static <R> R findResource(ResourceDescriptor<R> resdesc) {
		R result = (R) loaded_resources.get(resdesc);

		if (result == null) {
				result = resdesc.newInstance();
				if ( !loaded_resources.containsKey( resdesc) ){
					loaded_resources.put(resdesc, result);
				}
		}
		return result;
	}

	private Resources() {
	}
}
