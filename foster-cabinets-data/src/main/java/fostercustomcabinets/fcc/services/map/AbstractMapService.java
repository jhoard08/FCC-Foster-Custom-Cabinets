package fostercustomcabinets.fcc.services.map;

import fostercustomcabinets.fcc.model.BaseEntity;

import java.util.*;

public abstract class AbstractMapService<T extends BaseEntity, ID extends Long>
{
	protected Map<Long, T> map = new HashMap<>();

	Set<T> findAll()
	{
		return new HashSet<>(map.values());
	}

	T findById(ID id)
	{
		return map.get(id);
	}

	/**
	 * Sets the Id property automatically calling the getNextId() function to get the next
	 * available ID
	 * @param object
	 * @return
	 */
	T save(T object)
	{
		if(object != null){
			if(object.getId() == null){
				object.setId(getNextId());
			}
			map.put(object.getId(), object);
		} else{
			throw new RuntimeException("Object cannot be null");
		}

		return object;
	}

	void deleteById(ID id)
	{
		map.remove(id);
	}

	void delete(T object)
	{
		map.entrySet().removeIf(entry -> entry.getValue().equals(object));
	}

	/**
	 * Looks for the last known ID and adds one returning a new ID for an Object
	 * if no ID exist and a NoSuchElementException is thrown set ID to 1
	 * @return
	 */
	private Long getNextId(){

		Long nextId = null;

		try {
			nextId = Collections.max(map.keySet()) + 1;
		} catch(NoSuchElementException e) {
			nextId = 1L;
		}

		return nextId;


	}

}
