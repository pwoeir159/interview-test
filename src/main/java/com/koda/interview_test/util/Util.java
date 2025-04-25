package com.koda.interview_test.util;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.data.jpa.domain.Specification;

import com.koda.interview_test.model.util.BetweenUtil;

import retrofit2.Call;
import retrofit2.Response;

public class Util {

	private static final Logger logger = LoggerFactory.getLogger(Util.class);
	
	private static final int DEFAULT_MAX_RETRY = 3;
	   
	private static final long BASE_RETRY_INTERVAL_MS = 1000L;
	
	public final static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

	public static final DateTimeFormatter YYYY_MM_DD = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	
	public static final DateTimeFormatter YYYYMMDD = DateTimeFormatter.ofPattern("yyyyMMdd");
	
	public final static DateTimeFormatter YYYYMMDD_HHMMSS = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");

	public static <T> List<T> replaceNullToList(List<T> list) {
		if (list == null) {
			return Collections.emptyList();
		} else {
			return list;
		}
	}

	public static <T> T replaceNullToT(T responseBody, Class<T> clazz) {
		if (responseBody == null) {
		    try {
                return clazz.getDeclaredConstructor().newInstance();
            } catch (InstantiationException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IllegalArgumentException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (SecurityException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
		    return null;
		} else {
			return responseBody;
		}
	}

	public static <D, V> V toVo(D dto, V vo) {
		BeanUtils.copyProperties(dto, vo);
		return vo;
	}
	
	public static LocalDateTime stringToLocalDateTimeNew(String string, String formatter) {
		return LocalDateTime.parse(string, DateTimeFormatter.ofPattern(formatter));
	}
	
    public static String localDateTimeToStringNew(LocalDateTime localDateTime, String formatter) {
        return localDateTime.format(DateTimeFormatter.ofPattern(formatter));
    }

	public static LocalDateTime stringToLocalDateTime(String str) {
		return LocalDateTime.parse(str, formatter);
	}
	
    public static LocalDate stringToLocalDate(String str) {
        LocalDate dateTime = LocalDate.parse(str, YYYYMMDD);
        return dateTime;
    }
	
    public static String localDateTimeToString(LocalDateTime time) {
        String dateStr = time.format(formatter);
        return dateStr;
    }

    public static String localDateToStringDate(LocalDate time) {
        String dateStr = time.format(YYYYMMDD);
        return dateStr;
    }
	
	public static String localDateToStringDateTime(LocalDate time) {
		String dateStr = time.format(YYYYMMDD_HHMMSS);
		return dateStr;
	}

	public static Set<String> sortSetToString(String str) {
	   return Arrays.stream(Optional.ofNullable(str).orElse("").split(","))
        .map(String :: trim)
        .collect(Collectors.toSet());
	}
	
	 // 通用的 API 调用方法
    public static <T> List<T> callListApi(String method, Object params, Class<T> dtoClass, Function<T, Call<List<T>>> apiCall) {
        if (!dtoClass.isInstance(params)) {
            throw new IllegalArgumentException("Invalid parameter type for " + apiCall);
        }
        
        @SuppressWarnings("unchecked")
        T dto = (T) params;
        Call<List<T>> call = apiCall.apply(dto);
        return Util.callListApi(call, method);
    }
    
    public static <T> T callApi(String method, Object params, Class<T> dtoClass, Function<T, Call<T>> apiCall) {
        if (!dtoClass.isInstance(params)) {
            throw new IllegalArgumentException("Invalid parameter type for " + apiCall);
        }
        
        @SuppressWarnings("unchecked")
        T dto = (T) params;
        Call<T> call = apiCall.apply(dto);
        return Util.callApi(call, method, dtoClass);
    }
    
    public static <T> int callCodeApi(String method, Object params, Class<T> dtoClass, Function<T, Call<T>> apiCall) {
        if (!dtoClass.isInstance(params)) {
            throw new IllegalArgumentException("Invalid parameter type for " + apiCall);
        }
        
        @SuppressWarnings("unchecked")
        T dto = (T) params;
        Call<T> call = apiCall.apply(dto);
        return Util.callCodeApi(call, method);
    }
	
	public static <T> T callApi(Call<T> call, String method, Class<T> clazz) {
        
        Response<T> response;
        int retryCount = 0;
        int maxRetries = DEFAULT_MAX_RETRY;
        long retryInterval = BASE_RETRY_INTERVAL_MS;
        
        while (retryCount <= maxRetries) {
            try {
                response = retryCount == 0 ? call.execute() : call.clone().execute();
                if(response.isSuccessful()) {
                    logInfo("API call successful", method);
                }else{
                    logWarn("API call successful", method, response.code(), response.message());
                }
                return Util.replaceNullToT(response.body(), clazz);
                
            } catch (IOException ioe) {
                logger.warn("API call failed on attempt {} with IOException, method={}, errormessage={}",
                        retryCount + 1, method, ioe.getMessage());
                if (retryCount == maxRetries) {
                    break;
                }
                try {
                    Thread.sleep(retryInterval);
                } catch (InterruptedException ie) {
                    Thread.currentThread().interrupt();
                    logger.error("Thread interrupted while waiting to retry API call, method={}",
                            method, ie);
                    break;
                }
                retryInterval *= 2; // Exponential backoff
            } catch (Exception ex) {
                logError("API call failed with Exception", method);
                ex.printStackTrace();
                return Util.replaceNullToT(null, clazz);
            }
            retryCount++;
        }
        return Util.replaceNullToT(null, clazz);
    }
    
    public static <T> List<T> callListApi(Call<List<T>> call, String method){
        
        Response<List<T>> response;
        int retryCount = 0;
        int maxRetries = DEFAULT_MAX_RETRY;
        long retryInterval = BASE_RETRY_INTERVAL_MS;
        
        while (retryCount <= maxRetries) {
            try {
                response = retryCount == 0 ? call.execute() : call.clone().execute();
                if(response.isSuccessful()) {
                    logInfo("API call successful", method);
                    return response.body();
                }else {
                	System.out.println(call.request().toString());
                    logWarn("API call successful", method, response.code(), response.message());
                    return Collections.emptyList();
                }
            } catch (IOException ioe) {
                logger.warn("API call failed on attempt {} with IOException, method={}, errormessage={}",
                        retryCount + 1, method, ioe.getMessage());
                
                if (retryCount == maxRetries) {
                    break;
                }
                
                try {
                    Thread.sleep(retryInterval);
                } catch (InterruptedException ie) {
                    Thread.currentThread().interrupt();
                    logger.error("Thread interrupted while waiting to retry API call, method={}",
                            method, ie);
                    break;
                }
                retryInterval *= 2; // Exponential backoff
            } catch (Exception ex) {
                logError("API call failed with Exception", method);
            }
            retryCount++;
        }
        return Collections.emptyList();
    }
    
    public static <T> int callCodeApi(Call<T> call, String method) {
    	
        Response<T> response;
        int retryCount = 0;
        int maxRetries = DEFAULT_MAX_RETRY;
        long retryInterval = BASE_RETRY_INTERVAL_MS;
        
        while (retryCount <= maxRetries) {
            try {
                response = retryCount == 0 ? call.execute() : call.clone().execute();
                if(response.isSuccessful()) {
                    logInfo("API call successful", method);
                }else{
                    logWarn("API call successful", method, response.code(), response.message());
                }
                return response.code();
                
            } catch (IOException ioe) {
                logger.warn("API call failed on attempt {} with IOException, method={}, errormessage={}",
                        retryCount + 1, method, ioe.getMessage());
                if (retryCount == maxRetries) {
                    break;
                }
                try {
                    Thread.sleep(retryInterval);
                } catch (InterruptedException ie) {
                    Thread.currentThread().interrupt();
                    logger.error("Thread interrupted while waiting to retry API call, method={}",
                            method, ie);
                    break;
                }
                retryInterval *= 2; // Exponential backoff
            } catch (Exception ex) {
                logError("API call failed with Exception", method);
                ex.printStackTrace();
                return 500;
            }
            retryCount++;
        }
        
        return 500;
    }
    
    /**
     * 2024-06-04.
     * SQL注入攻擊防範，使用JpaSpec.
     * by Koda.
     * 
     * @param  paramNameMap Map<String,Object>，參數名稱，參數內容
     * @param  betweenUtil BetweenUtil，如果有使用到時間Between，請使用這物件
     * @return Specification<T>
     * */
   public static <T, E> Specification<T> addSpec(Map<String,Object> paramNameMap, BetweenUtil betweenUtil){
       
       Specification<T> spec = Specification.where(null);
 
       for(Map.Entry<String, Object> entry : paramNameMap.entrySet()) {
           
           if(entry.getValue() == null) {
               continue;
           }
           
           spec = spec.and((root, query, builder) -> 
               root.get(entry.getKey()).in(Arrays.asList(entry.getValue().toString().split(","))));
       }
       
       if(betweenUtil != null) {
           
           if("LocalDateTime".equals(betweenUtil.getParamType().toString())) {
               spec = spec.and((root, query, builder) -> 
                   builder.between(root.get(betweenUtil.getParamName()), betweenUtil.getStartLocalDateTime(), betweenUtil.getEndLocalDateTime()));
           }else {
               spec = spec.and((root, query, builder) -> 
                   builder.between(root.get(betweenUtil.getParamName()), betweenUtil.getStartLocalDate(), betweenUtil.getEndLocalDate()));
           }
       }
       
       return spec;
   }
    
    private static void logInfo(String message, String method) {
        logger.info("{}, method={}",message, method);
    }
    
    private static void logWarn(String message, String method, int code, String errormessage) {
        logger.warn("{}, method={}, code={}, errormessage={}",message, method, code, errormessage);
    }

    private static void logError(String message, String method) {
        logger.error("{}, method={}",message, method);
    }
}