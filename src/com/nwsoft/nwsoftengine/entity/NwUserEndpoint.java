package com.nwsoft.nwsoftengine.entity;

import com.nwsoft.nwsoftengine.entity.PMF;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.api.server.spi.response.CollectionResponse;
import com.google.appengine.api.datastore.Cursor;
import com.google.appengine.datanucleus.query.JDOCursorHelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Nullable;
import javax.inject.Named;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;

@Api(name = "nwuserendpoint", 
	namespace = @ApiNamespace(ownerDomain = "nwsoft.com", 
							ownerName = "nwsoft.com", 
							packagePath = "nwsoftengine.entity"),
	description="APIs for user profile of nwsoft")
public class NwUserEndpoint {

	/**
	 * This method lists all the entities inserted in datastore.
	 * It uses HTTP GET method and paging support.
	 *
	 * @return A CollectionResponse class containing the list of all entities
	 * persisted and a cursor to the next page.
	 */
	@SuppressWarnings({ "unchecked", "unused" })
	@ApiMethod(name = "listNwUser")
	public CollectionResponse<NwUser> listNwUser(
			@Nullable @Named("cursor") String cursorString,
			@Nullable @Named("limit") Integer limit) {

		PersistenceManager mgr = null;
		Cursor cursor = null;
		List<NwUser> execute = null;

		try {
			mgr = getPersistenceManager();
			Query query = mgr.newQuery(NwUser.class);
			if (cursorString != null && cursorString != "") {
				cursor = Cursor.fromWebSafeString(cursorString);
				HashMap<String, Object> extensionMap = new HashMap<String, Object>();
				extensionMap.put(JDOCursorHelper.CURSOR_EXTENSION, cursor);
				query.setExtensions(extensionMap);
			}

			if (limit != null) {
				query.setRange(0, limit);
			}

			execute = (List<NwUser>) query.execute();
			cursor = JDOCursorHelper.getCursor(execute);
			if (cursor != null)
				cursorString = cursor.toWebSafeString();

			// Tight loop for fetching all entities from datastore and accomodate
			// for lazy fetch.
			for (NwUser obj : execute)
				;
		} finally {
			mgr.close();
		}

		return CollectionResponse.<NwUser> builder().setItems(execute)
				.setNextPageToken(cursorString).build();
	}

	/**
	 * This method gets the entity having primary key id. It uses HTTP GET method.
	 *
	 * @param id the primary key of the java bean.
	 * @return The entity with primary key id.
	 */
	@ApiMethod(name = "getNwUser")
	public NwUser getNwUser(@Named("id") Long id) {
		PersistenceManager mgr = getPersistenceManager();
		NwUser nwuser = null;
		try {
			nwuser = mgr.getObjectById(NwUser.class, id);
		} finally {
			mgr.close();
		}
		return nwuser;
	}
	
	@ApiMethod(name="getNwUserByUserEmail")
	public List<NwUser> getNwUserByUserEmail(@Named("userEmail") String userEmail) {
		List<NwUser> users=new ArrayList<>();
		PersistenceManager pm = getPersistenceManager();
		//
//		Query q = pm.newQuery("select from NwUser " +
//								"where userEmail == userParm " +
//								"parameters String userParm " +
//								"order by userEmail desc");
//		List<NwUser> u=(List<NwUser>) q.execute(userEmail);
//		System.out.println("toArray.toString " + u.toArray().toString());
		//
		Query query = pm.newQuery(NwUser.class);
		query.setFilter("userEmail == pUserEmail");	
		query.declareParameters("String pUserEmail");
		query.setOrdering("userEmail desc");
		try {
			users = (List<NwUser>) query.execute(userEmail);
			if (!users.isEmpty()) {
				for (NwUser user: users) {
					System.out.println(user.getUserEmail());
				}
				return users;
			} else {
				
			}
		} finally {
			pm.close();
		}
		return users;
	}
	/**
	 * This inserts a new entity into App Engine datastore. If the entity already
	 * exists in the datastore, an exception is thrown.
	 * It uses HTTP POST method.
	 *
	 * @param nwuser the entity to be inserted.
	 * @return The inserted entity.
	 */
	@ApiMethod(name = "insertNwUser")
	public NwUser insertNwUser(NwUser nwuser) {
		PersistenceManager mgr = getPersistenceManager();
		try {
			if (nwuser.getId() != null) {
				if (containsNwUser(nwuser)) {
					throw new EntityExistsException("Object already exists");
				}
			}
			mgr.makePersistent(nwuser);
		} finally {
			mgr.close();
		}
		return nwuser;
	}

	/**
	 * This method is used for updating an existing entity. If the entity does not
	 * exist in the datastore, an exception is thrown.
	 * It uses HTTP PUT method.
	 *
	 * @param nwuser the entity to be updated.
	 * @return The updated entity.
	 */
	@ApiMethod(name = "updateNwUser")
	public NwUser updateNwUser(NwUser nwuser) {
		PersistenceManager mgr = getPersistenceManager();
		try {
			if (!containsNwUser(nwuser)) {
				throw new EntityNotFoundException("Object does not exist");
			}
			mgr.makePersistent(nwuser);
		} finally {
			mgr.close();
		}
		return nwuser;
	}

	/**
	 * This method removes the entity with primary key id.
	 * It uses HTTP DELETE method.
	 *
	 * @param id the primary key of the entity to be deleted.
	 */
	@ApiMethod(name = "removeNwUser")
	public void removeNwUser(@Named("id") Long id) {
		PersistenceManager mgr = getPersistenceManager();
		try {
			NwUser nwuser = mgr.getObjectById(NwUser.class, id);
			mgr.deletePersistent(nwuser);
		} finally {
			mgr.close();
		}
	}

	private boolean containsNwUser(NwUser nwuser) {
		PersistenceManager mgr = getPersistenceManager();
		boolean contains = true;
		try {
			mgr.getObjectById(NwUser.class, nwuser.getId());
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
