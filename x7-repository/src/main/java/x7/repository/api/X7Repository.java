/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package x7.repository.api;

import x7.core.bean.Criteria;
import x7.core.bean.CriteriaCondition;
import x7.core.bean.IQuantity;
import x7.core.bean.condition.InCondition;
import x7.core.bean.condition.ReduceCondition;
import x7.core.bean.condition.RefreshCondition;
import x7.core.web.Direction;
import x7.core.web.Pagination;

import java.util.List;
import java.util.Map;

/**
 * 
 * @author Sim
 *
 * @param <T>
 */
public interface X7Repository<T> {

	void set(byte[] key, byte[] value);

	byte[] get(byte[] key);

	void set(String key, String value, int seconds);

	void set(String key, String value);

	String get(String key);

	long createId();

	/**
	 * @param obj
	 * @param reduced
	 * @return currentQuantity
	 */
	int reduce(IQuantity obj, int reduced);

	boolean createBatch(List<T> objList);

	long create(T obj);

	void refreshCache();

	/**
	 * @param obj
	 */
	boolean refresh(T obj);

	boolean refresh(RefreshCondition<T> refreshCondition);
	boolean refreshUnSafe(RefreshCondition<T> refreshCondition);
	/**
	 * @param obj
	 */
	void remove(T obj);

	/**
	 *
	 * @param idOne
	 * 
	 */
	T get(long idOne);


	/**
	 * LOAD
	 *
	 * @return
	 */
	List<T> list();

	/**
	 * 根据对象查询
	 * 
	 * @param conditionObj
	 * 
	 */
	List<T> list(T conditionObj);

	T getOne(T conditionObj, String orderBy, Direction sc);

	T getOne(T conditionObj);

	/**
	 * in API
	 * @param inCondition
	 * @return
	 */
	List<T> in(InCondition inCondition);

	/**
	 * Standard query pageable API
	 * 
	 * @param criteria
	 * 
	 */
	Pagination<T> find(Criteria criteria);

	/**
	 * Standard query pageable API, FETCH supported
	 * 
	 * @param criteria
	 */
	Pagination<Map<String, Object>> find(Criteria.ResultMapped criteria);

	/**
	 *  SUM | COUNT | AVG | MIN | MAX
	 * @param condition
	 * @return Object
	 */
	Object reduce(ReduceCondition condition);
}