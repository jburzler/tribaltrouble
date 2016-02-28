package com.oddlabs.util;

public abstract strictfp class ListElementImpl implements ListElement {
	private LinkedList parent;

	private ListElement next = null;
	private ListElement prior = null;

        @Override
	public final void setListOwner(LinkedList owner) {
		parent = owner;
	}

        @Override
	public final LinkedList getListOwner() {
		return parent;
	}

        @Override
	public final void setPrior(ListElement prior) {
		this.prior = prior;
	}

        @Override
	public final void setNext(ListElement next) {
		this.next = next;
	}

        @Override
	public final ListElement getPrior() {
		return prior;
	}

        @Override
	public final ListElement getNext() {
		return next;
	}
}
