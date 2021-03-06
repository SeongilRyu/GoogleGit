package com.nwsoft.nwsoftengine.entity;

import com.nwsoft.nwsoftengine.entity.PMF;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.api.server.spi.response.CollectionResponse;
import com.google.appengine.api.datastore.Cursor;
import com.google.appengine.datanucleus.query.JDOCursorHelper;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Nullable;
import javax.inject.Named;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;

@Api(name = "quotejdoendpoint", namespace = @ApiNamespace(ownerDomain = "nwsoft.com", 
			ownerName = "nwsoft.com", packagePath = "nwsoftengine.entity"))
public class QuoteJDOEndpoint {

	/**
	 * This method lists all the entities inserted in datastore.
	 * It uses HTTP GET method and paging support.
	 *
	 * @return A CollectionResponse class containing the list of all entities
	 * persisted and a cursor to the next page.
	 */
	@SuppressWarnings({ "unchecked", "unused" })
	@ApiMethod(name = "listQuoteJDO", path="listQuoteJDO")
	public CollectionResponse<QuoteJDO> listQuoteJDO(
			@Nullable @Named("cursor") String cursorString,
			@Nullable @Named("limit") Integer limit) {

		PersistenceManager mgr = null;
		Cursor cursor = null;
		List<QuoteJDO> execute = null;

		try {
			mgr = getPersistenceManager();
			Query query = mgr.newQuery(QuoteJDO.class);
			if (cursorString != null && cursorString != "") {
				cursor = Cursor.fromWebSafeString(cursorString);
				HashMap<String, Object> extensionMap = new HashMap<String, Object>();
				extensionMap.put(JDOCursorHelper.CURSOR_EXTENSION, cursor);
				query.setExtensions(extensionMap);
			}

			if (limit != null) {
				query.setRange(0, limit);
			}

			execute = (List<QuoteJDO>) query.execute();
			cursor = JDOCursorHelper.getCursor(execute);
			if (cursor != null)
				cursorString = cursor.toWebSafeString();

			// Tight loop for fetching all entities from datastore and accomodate
			// for lazy fetch.
			for (QuoteJDO obj : execute)
				;
		} finally {
			mgr.close();
		}

		return CollectionResponse.<QuoteJDO> builder().setItems(execute)
				.setNextPageToken(cursorString).build();
	}

	/**
	 * This method gets the entity having primary key id. It uses HTTP GET method.
	 *
	 * @param id the primary key of the java bean.
	 * @return The entity with primary key id.
	 */
	@ApiMethod(name = "getQuoteJDO",path="getQuoteJDO")
	public QuoteJDO getQuoteJDO(@Named("id") Long id) {
		PersistenceManager mgr = getPersistenceManager();
		QuoteJDO quotejdo = null;
		try {
			quotejdo = mgr.getObjectById(QuoteJDO.class, id);
		} finally {
			mgr.close();
		}
		return quotejdo;
	}

	/**
	 * This inserts a new entity into App Engine datastore. If the entity already
	 * exists in the datastore, an exception is thrown.
	 * It uses HTTP POST method.
	 *
	 * @param quotejdo the entity to be inserted.
	 * @return The inserted entity.
	 */
	@ApiMethod(name = "insertQuoteJDO",path="insertQuoteJDO")
	public QuoteJDO insertQuoteJDO(QuoteJDO quotejdo) {
		PersistenceManager mgr = getPersistenceManager();
		try {
			if (quotejdo.getId()!=null) {	//add by sir
				if (containsQuoteJDO(quotejdo)) {
					throw new EntityExistsException("Object already exists");
				}
			} // add by sir
			mgr.makePersistent(quotejdo);
		} finally {
			mgr.close();
		}
		return quotejdo;
	}

	/**
	 * This method is used for updating an existing entity. If the entity does not
	 * exist in the datastore, an exception is thrown.
	 * It uses HTTP PUT method.
	 *
	 * @param quotejdo the entity to be updated.
	 * @return The updated entity.
	 */
	@ApiMethod(name = "updateQuoteJDO",path="updateQuoteJDO")
	public QuoteJDO updateQuoteJDO(QuoteJDO quotejdo) {
		PersistenceManager mgr = getPersistenceManager();
		try {
			if (!containsQuoteJDO(quotejdo)) {
				throw new EntityNotFoundException("Object does not exist");
			}
			mgr.makePersistent(quotejdo);
		} finally {
			mgr.close();
		}
		return quotejdo;
	}

	/**
	 * This method removes the entity with primary key id.
	 * It uses HTTP DELETE method.
	 *
	 * @param id the primary key of the entity to be deleted.
	 */
	@ApiMethod(name = "removeQuoteJDO",path="removeQuoteJDO")
	public void removeQuoteJDO(@Named("id") Long id) {
		PersistenceManager mgr = getPersistenceManager();
		try {
			QuoteJDO quotejdo = mgr.getObjectById(QuoteJDO.class, id);
			mgr.deletePersistent(quotejdo);
		} finally {
			mgr.close();
		}
	}

	private boolean containsQuoteJDO(QuoteJDO quotejdo) {
		PersistenceManager mgr = getPersistenceManager();
		boolean contains = true;
		try {
			mgr.getObjectById(QuoteJDO.class, quotejdo.getId());
		} catch (javax.jdo.JDOObjectNotFoundException ex) {
			contains = false;
		} finally {
			mgr.close();
		}
		return contains;
	}

	private static PersistenceManager getPersistenceManager() {
		return PMF.get().getPersistenceManager();
	}

}
