package ca.uhn.fhir.jpa.interceptor.validation;

/*-
 * #%L
 * HAPI FHIR Storage api
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

import ca.uhn.fhir.context.FhirContext;
import org.apache.commons.lang3.Validate;

import javax.annotation.Nonnull;

abstract class BaseTypedRule implements IRepositoryValidatingRule {

	private final String myResourceType;
	private final FhirContext myFhirContext;

	protected BaseTypedRule(FhirContext theFhirContext, String theResourceType) {
		Validate.notNull(theFhirContext);
		Validate.notBlank(theResourceType);
		myFhirContext = theFhirContext;
		myResourceType = theResourceType;
	}

	@Nonnull
	@Override
	public String getResourceType() {
		return myResourceType;
	}

	protected FhirContext getFhirContext() {
		return myFhirContext;
	}

}
