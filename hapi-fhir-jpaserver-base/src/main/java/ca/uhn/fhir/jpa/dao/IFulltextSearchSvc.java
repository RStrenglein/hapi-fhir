package ca.uhn.fhir.jpa.dao;

/*
 * #%L
 * HAPI FHIR JPA Server
 * %%
 * Copyright (C) 2014 - 2021 Smile CDR, Inc.
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import java.util.List;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.jpa.model.search.ExtendedLuceneIndexData;
import ca.uhn.fhir.jpa.searchparam.extractor.ResourceIndexedSearchParams;
import ca.uhn.fhir.rest.api.server.storage.ResourcePersistentId;
import ca.uhn.fhir.jpa.searchparam.SearchParameterMap;
import ca.uhn.fhir.rest.api.server.RequestDetails;
import org.hl7.fhir.instance.model.api.IBaseResource;

public interface IFulltextSearchSvc {


	/**
	 * Search the Lucene/Elastic index for pids using params supported in theParams,
	 * consuming entries from theParams when used to query.
	 *
	 * @param theResourceName the resource name to restrict the query.
	 * @param theParams the full query - modified to return only params unused by the index.
	 * @return the pid list for the matchign resources.
	 */
	List<ResourcePersistentId> search(String theResourceName, SearchParameterMap theParams);

	List<ResourcePersistentId> everything(String theResourceName, SearchParameterMap theParams, RequestDetails theRequest);

	boolean isDisabled();

	ExtendedLuceneIndexData extractLuceneIndexData(FhirContext theContext, IBaseResource theResource, ResourceIndexedSearchParams theNewParams);

    boolean supportsSomeOf(SearchParameterMap myParams);
}
