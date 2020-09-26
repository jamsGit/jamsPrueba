package com.example.tiendaconfig;

import org.hibernate.envers.RevisionListener;

import com.example.tienda.entities.audit.Revision;

public class CustomRevisionListener implements RevisionListener {

	@Override
	public void newRevision(Object revisionEntity) {
		final Revision revision = (Revision) revisionEntity;
	}

}
