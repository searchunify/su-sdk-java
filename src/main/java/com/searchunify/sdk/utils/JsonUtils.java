package com.searchunify.sdk.utils;

import java.io.IOException;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.searchunify.sdk.dtos.SearchUnifyRequest;
import com.searchunify.sdk.exceptions.SearchUnifyException;

/**
 * This class is @author ankur
 * This class is created at 22-Mar-2021
 */
public final class JsonUtils {

	public static final ObjectMapper mapper = new ObjectMapper()
			.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
			.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false)
			.setSerializationInclusion(Include.NON_NULL);
	// .registerModule(new AfterburnerModule());

	/**
	 * This method is used to convert object to JSON.
	 * 
	 * Parameters @param obj
	 * @return {@link String}
	 */
	public static String toJsonString(final Object obj) {
		try {
			return mapper.writeValueAsString(obj);
		} catch (JsonGenerationException e) {
			throw new SearchUnifyException("Unable to generate json.", e);
		} catch (JsonMappingException e) {
			throw new SearchUnifyException("Unable to map json.", e);
		} catch (IOException e) {
			throw new SearchUnifyException("IO error.", e);
		}
	}

	/**
	 * This method is used to convert the JSON to the POJO.
	 * 
	 * Parameters @param json
	 * Parameters @param Class<T> clz
	 * @return T
	 */
	public static <T> T jsonToObject(final String json, Class<T> clz) {
		try {
			T object = mapper.readValue(json, clz);
			return object;
		} catch (JsonGenerationException e) {
			throw new SearchUnifyException("Unable to generate json.", e);
		} catch (JsonMappingException e) {
			throw new SearchUnifyException("Unable to map json.", e);
		} catch (IOException e) {
			throw new SearchUnifyException("IO error.", e);
		}
	}

	/**
	 * This method is used to check if the string is valid JSON or not.
	 * 
	 * Parameters @param json
	 * @return {@link Boolean}
	 * @throws SearchUnifyException
	 */
	public static boolean isValidJSON(final String json) throws SearchUnifyException {
		boolean valid = true;
		try {
			mapper.readTree(json);
		} catch (JsonProcessingException e) {
			valid = false;
			throw new SearchUnifyException("Unable to parse JSON.", e);
		}
		return valid;
	}

	/**
	 * This method is used to convert the map object to a pojo.
	 * 
	 * Parameters @param <T>
	 * Parameters @param map
	 * Parameters @param clz
	 * @return T
	 */
	public static <T> T convertMapToObject(Map<String, Object> map, Class<T> clz) {
		try {
			T object = mapper.convertValue(map, clz);
			return object;
		} catch (IllegalArgumentException e) {
			throw new SearchUnifyException("Unable to generate json.", e);
		}
	}

	/**
	 * This method is used to convert POJO to {@link Map}.
	 * 
	 * Parameters @param <R>
	 * Parameters @param request
	 * @return Map<String, String>
	 */
	public static <R extends SearchUnifyRequest> Map<String, String> convertPojoToMap(R request) {
		Map<String, String> map = mapper.convertValue(request, new TypeReference<Map<String, String>>() {
		});
		return map;
	}

}
