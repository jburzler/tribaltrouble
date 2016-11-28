package com.oddlabs.tt.resource;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public abstract strictfp class NativeResource  {

    private final static List<NativeResource> finalized_resources = new ArrayList<>();
    private static AtomicInteger count = new AtomicInteger(0);

    public NativeResource() {
        count.incrementAndGet();
    }

    @Override
    protected final void finalize() throws Throwable {
        try {
            synchronized (finalized_resources) {
                finalized_resources.add(this);
            }
        } finally {
            super.finalize();
        }
    }

    public final static void deleteFinalized() {
        synchronized (finalized_resources) {
            for (int i = 0; i < finalized_resources.size(); i++) {
                NativeResource r = finalized_resources.get(i);
                count.decrementAndGet();
                r.doDelete();
            }
            finalized_resources.clear();
        }
    }

    public final static void gc() {
        System.gc();
        Runtime.getRuntime().runFinalization();
        deleteFinalized();
    }

    public final static int getCount() {
        return count.get();
    }

    protected abstract void doDelete();
}
