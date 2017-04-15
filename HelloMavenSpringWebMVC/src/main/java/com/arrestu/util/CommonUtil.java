package com.arrestu.util;

import java.lang.ref.SoftReference;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.file.DirectoryStream.Filter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Enumeration;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TimeZone;
import java.util.TreeMap;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.validation.Validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

public class CommonUtil {
	private static Logger logger = LoggerFactory.getLogger(CommonUtil.class);

	public static String dateToString(Date date, String Format) {
		if (date != null) {
			SimpleDateFormat formatter = new SimpleDateFormat(Format);
			return formatter.format(date);
		} else {
			return null;
		}
	}

	public static String dateToEmptyString(Date date, String Format) {
		if (date != null) {
			SimpleDateFormat formatter = new SimpleDateFormat(Format);
			return formatter.format(date);
		} else {
			return " ";
		}
	}

	public static Date stringToDate(String dateString, String dateFormat) throws Exception {
		Date date = null;
		try {
			if (dateString != null) {
				DateFormat formatter;
				formatter = new SimpleDateFormat(dateFormat);
				date = (Date) formatter.parse(dateString);
			}
		} catch (ParseException e) {
			logger.error("Strin to date parser exception ", e);
			throw new Exception(e.getMessage());
		}
		return date;
	}

	// Comma Seperated String to Array List
	public static List<String> stringToList(String commaSeparatedStr) {
		List<String> items = Arrays.asList(commaSeparatedStr.split("\\s*,\\s*"));
		return items;
	}

	public static Date xmlGregorianCalToDate(XMLGregorianCalendar xmlGregCal) {
		logger.info("xmlGregCal is "+xmlGregCal);
		Date date = null;
		if (xmlGregCal != null) {
			date = xmlGregCal.toGregorianCalendar().getTime();
		}
		logger.info("date is "+date);
		return date;
	}

	public static XMLGregorianCalendar dateToXMLGregorianCal(Date date) {
		if (date == null) {

			return null;
		} else {
			try {
				DatatypeFactory df = DatatypeFactory.newInstance();
				GregorianCalendar gc = new GregorianCalendar();
				gc.setTimeInMillis(date.getTime());
				return df.newXMLGregorianCalendar(gc);
			} catch (Exception e) {
				logger.info("Exception while converting date to xmlGregorianCalendar");
				return null;
			}
		}
	}

	public static boolean isEmpty(String str) {
		return StringUtils.isEmpty(str);
	}

	public static boolean isStringEmptyorStringNull(String str) {
		if (StringUtils.isEmpty(str) || "null".equalsIgnoreCase(str) || str == null) {
			return true;
		}
		return false;
	}

	public static boolean isEmpty(Collection coll) {
		return (coll == null || coll.isEmpty());
	}

	public static String toLower(String value) {
		if (value != null) {
			value = value.toLowerCase();
		}
		return value;
	}

	public static String toUpper(String value) {
		if (value != null) {
			value = value.toUpperCase();
		}
		return value;
	}

	public static int stringToInt(String value) {
		int strValue = 0;
		if (!isEmpty(value)) {
			strValue = Integer.parseInt(value);
		}
		return strValue;
	}

	public static Integer stringToInteger(String value) {
		Integer strValue = null;
		if (!isEmpty(value)) {
			strValue = Integer.valueOf(value);
		}
		return strValue;
	}


	public static String removeLastCharFromString(String stringValue) {
		return stringValue.substring(0, stringValue.length() - 1);
	}

	public static String removeLastCharFromStringBuffer(StringBuffer stringValue) {
		return stringValue.substring(0, stringValue.length() - 1);
	}

	public static String removeLastCharFromStringBuilder(StringBuilder stringValue) {
		return stringValue.substring(0, stringValue.length() - 1);
	}

	public static boolean checkLength(String str, int length) {
		if (str != null) {
			if (str.length() <= length) {
				return true;
			} else {
				return false;
			}
		} else {
			return true;
		}
	}

	public static Calendar resetTime(Calendar timeStamp, int hour, int minutes, int seconds) {
		Calendar resetDate = Calendar.getInstance();
		resetDate = timeStamp;
		resetDate.set(Calendar.HOUR_OF_DAY, hour);
		resetDate.set(Calendar.MINUTE, minutes);
		resetDate.set(Calendar.SECOND, seconds);

		return timeStamp;
	}

	public static boolean validateRegexMandatory(String regex, String value) {
		if (!StringUtils.isEmpty(value)) {
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(value);
			return matcher.matches();
		}
		return false;
	}

	public static boolean validateRegexOptional(String regex, String value) {
		if (!StringUtils.isEmpty(value)) {
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(value);
			return matcher.matches();
		}
		return true;
	}

	final static Pattern EMAILPATTERN = Pattern.compile("^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

	public static boolean validateEmailAddress(String str) {
		boolean tmp = false;
		if (str != null) {
			final Matcher matcher = EMAILPATTERN.matcher(str);
			tmp = matcher.matches();
		}
		return tmp;
	}

	public static boolean isNumberChar(String text) {
		boolean ret = false;
		for (int i = 0; i < text.length(); i++) {
			int c = text.charAt(i);
			if ((48 <= c) && (c <= 57)) {
				ret = true;
				break;
			}
			ret = false;
		}
		return ret;
	}

	public static Date getSLAExpiredDate(int slaDays, int hoursToAdd, int minsToAdd) {
		Calendar cal = Calendar.getInstance();

		TimeZone z = cal.getTimeZone();
		int offset = z.getRawOffset();
		if (z.inDaylightTime(new Date())) {
			offset = offset + z.getDSTSavings();
		}
		int offsetHrs = offset / 1000 / 60 / 60;
		int offsetMins = offset / 1000 / 60 % 60;

		cal.add(Calendar.HOUR_OF_DAY, (-offsetHrs));
		cal.add(Calendar.MINUTE, (-offsetMins));
		cal.add(Calendar.HOUR_OF_DAY, hoursToAdd);
		cal.add(Calendar.MINUTE, minsToAdd);
		cal.add(Calendar.DATE, slaDays);

		cal.set(Calendar.HOUR_OF_DAY, 23);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.SECOND, 59);
		cal.set(Calendar.MILLISECOND, 999);
		return cal.getTime();
	}

	public static Double stringToDouble(String value) {
		Double dblValue = null;
		if (value != null && !value.isEmpty()) {
			dblValue = Double.valueOf(value);
		}
		return dblValue;
	}

	public static double stringTodouble(String value) {
		double dblValue = 0;
		if (value != null && !value.isEmpty()) {
			dblValue = Double.parseDouble(value);
		}
		return dblValue;
	}

	public static Long stringToLong(String value) throws Exception {
		Long dblValue = null;
		try {
			dblValue = Long.parseLong(value);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		return dblValue;
	}

	





	public static Date getFromDate(String date, String format) throws Exception {
		Date fromDate = null;
		if (!CommonUtil.isEmpty(date)) {
			Date convDate = stringToDate(date, format);
			Calendar cal = Calendar.getInstance();
			cal.setTime(convDate);
			cal.set(Calendar.HOUR_OF_DAY, 00);
			cal.set(Calendar.MINUTE, 00);
			cal.set(Calendar.SECOND, 00);
			cal.set(Calendar.MILLISECOND, 000);
			fromDate = cal.getTime();
		}
		return fromDate;
	}

	public static Date getToDate(String date, String format) throws Exception {
		Date toDate = null;
		if (!CommonUtil.isEmpty(date)) {
			Date convDate = stringToDate(date, format);
			Calendar cal = Calendar.getInstance();

			cal.setTime(convDate);
			cal.set(Calendar.HOUR_OF_DAY, 23);
			cal.set(Calendar.MINUTE, 59);
			cal.set(Calendar.SECOND, 59);
			cal.set(Calendar.MILLISECOND, 999);
			toDate = cal.getTime();
		}
		return toDate;
	}

	private static ExecutorService executorService = new ThreadPoolExecutor(10, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue<Runnable>(), new ThreadFactory() {

		public synchronized Thread newThread(Runnable r) {
			return new Thread(r, "FPCAsyncThread");
		}
	});

	public static Future executeAsynchronous(Callable callable) {
		return executorService.submit(callable);
	}

	public static void executeAsynchronous(Runnable runnable) {
		executorService.execute(runnable);
	}

	public static ExecutorService getExecutorService() {
		return executorService;
	}

	public static Integer objToInt(Object param, Integer defVal) throws Exception {
		Integer retVal = defVal;
		try {
			retVal = Integer.parseInt(StringUtils.trimAllWhitespace(String.valueOf(param)));
		} catch (NumberFormatException e) {
			throw new Exception(e.getMessage());
		}
		return retVal;
	}

	public static int bigDecimalToInt(BigDecimal bigDecimal) {
		int intVal = 0;
		if (null != bigDecimal) {
			intVal = bigDecimal.intValue();
		}
		return intVal;
	}

	public static String bigDecimalToString(BigDecimal bigDecimal) {
		String strVal = null;
		if (null != bigDecimal) {
			strVal = bigDecimal.toString();
		}
		return strVal;
	}

	public static long bigDecimalToLong(BigDecimal bigDecimal) {
		if (null != bigDecimal) {
			return bigDecimal.longValue();
		}
		return 0;
	}

	public static boolean isLocalURL(String serverURL) {
		boolean retVal = false;
		InetAddress address;
		try {
			int temp = serverURL.lastIndexOf(":");
			serverURL = serverURL.substring(serverURL.indexOf("//") + 2, temp);
			address = InetAddress.getLocalHost();
			if ("localhost".equalsIgnoreCase(serverURL) || serverURL.equalsIgnoreCase(address.getHostAddress()) || serverURL.equalsIgnoreCase(address.getHostName()) || serverURL.equalsIgnoreCase(address.getCanonicalHostName())) {
				retVal = true;
			}
		} catch (UnknownHostException e) {
			logger.error("UnknownHostException ", e);
		} catch (Exception e) {
			logger.error("MalformedURLException ", e);
		}
		return retVal;
	}

	private static final long MEGABYTE = 1024L * 1024L;

	public static long bytesToMegabytes(long bytes) {
		return bytes / MEGABYTE;
	}

	public static void logMemoryDetails() {
		// Get the Java runtime
		Runtime runtime = Runtime.getRuntime();
		// Run the garbage collector
		runtime.gc();
		// Calculate the used memory
		long memory = runtime.totalMemory() - runtime.freeMemory();
		logger.debug("Total Memory " + bytesToMegabytes(runtime.totalMemory()));
		logger.debug("Free Memory " + bytesToMegabytes(runtime.freeMemory()));
		logger.debug("Used Memory  " + bytesToMegabytes(memory));
	}

	public static void burstMemory() throws Exception {
		try {
			final SoftReference allocated = new SoftReference(new LinkedList());
			boolean finished = false;

			while (!finished) {
				byte[] data = new byte[10 * 1000 * 1000];
				List tmp = (List) allocated.get();
				if (tmp != null) {
					tmp.add(data);
					logger.debug("reference is added current list size " + tmp.size());
					CommonUtil.logMemoryDetails();

				} else {
					logger.debug("reference has been collected, finishing");
					finished = true;
					CommonUtil.logMemoryDetails();
				}
			}
		} catch (OutOfMemoryError t) {
			logger.debug("out of memory reached, releasing memory");
			throw new Exception(t.getMessage());
		}

	}

	public static Calendar currentTimeinIST() throws Exception {
		TimeZone timeZone = TimeZone.getTimeZone("IST");
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSSSS");
		format.setTimeZone(timeZone);
		Calendar currentISTTime = new GregorianCalendar();
		currentISTTime.setTime(CommonUtil.stringToDate(format.format(new Date()), "yyyy-MM-dd HH:mm:ss.SSSSSS"));
		return currentISTTime;
	}

	public static <T> List<List<T>> splitArrayListByNumber(List<T> ls, final int iParts) {
		final List<List<T>> lsParts = new ArrayList<List<T>>();
		final int splitSize = ls.size() / iParts;
		int balance = ls.size() % iParts;
		int endLimit = splitSize;

		for (int i = 0, iT = ls.size(); i < iT; i += endLimit) {
			if (balance > 0) {
				balance--;
				endLimit = splitSize + 1;
			} else {
				endLimit = splitSize;
			}

			lsParts.add(new ArrayList<T>(ls.subList(i, Math.min(iT, i + endLimit))));
		}

		return lsParts;
	}

	public static Calendar getCalendarForNow(Date date) {
		Calendar calendar = GregorianCalendar.getInstance();
		calendar.setTime(date);
		return calendar;
	}

	public static void setTimeToBeginningOfDay(Calendar calendar) {
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
	}

	public static void setTimeToEndofDay(Calendar calendar) {
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		calendar.set(Calendar.MILLISECOND, 999);
	}

	public static Date getCurrentMonthStartTime(Date date) {
		Calendar calendar = GregorianCalendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
		setTimeToBeginningOfDay(calendar);
		return calendar.getTime();
	}

	public static Date getCurrentMonthEndTime(Date date) {
		Calendar calendar = GregorianCalendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
		setTimeToBeginningOfDay(calendar);
		return calendar.getTime();
	}

	public static Date getDateInStartTime(Date date) {
		Calendar calendar = GregorianCalendar.getInstance();
		calendar.setTime(date);
		setTimeToBeginningOfDay(calendar);
		return calendar.getTime();
	}

	public static Date getPreviusMonthStartTime(Date date) {
		Calendar calendar = GregorianCalendar.getInstance();
		calendar.setTime(date);
		setTimeToBeginningOfDay(calendar);
		calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
		calendar.add(Calendar.MONTH, -1);
		return calendar.getTime();
	}

	public static Date getPrevMonthEndDateAndStartTime(Date currentDate) {
		Calendar calendar = GregorianCalendar.getInstance();
		calendar.setTime(currentDate);
		calendar.add(Calendar.MONTH, -1);
		calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
		CommonUtil.setTimeToBeginningOfDay(calendar);
		return calendar.getTime();
	}



	public static void getEntryMethod() {
		StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
		String methodName = stackTraceElements[3].getMethodName();
		String className = stackTraceElements[3].getClassName();
		logger.info("Entering method: " + methodName + " of Class: " + className);
	}

	public static void getExitMethod() {
		StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
		String methodName = stackTraceElements[3].getMethodName();
		String className = stackTraceElements[3].getClassName();
		logger.info("Exiting method: " + methodName + " of Class: " + className);
	}

/*	public static <T> T getFirstMatch(final List<T> collection, final Filter filter) {
		if (collection == null || collection.isEmpty()) {
			return null;
		}
		for (T t : collection) {
			if (filter.include(t)) {
				logger.info("inside" + t.toString());
				return t;
			}
		}
		return null;
	}*/

/*	public static <T> T getFirstMatch(final Set<T> collection, final Filter filter) {
		if (collection == null || collection.isEmpty()) {
			return null;
		}
		for (T t : collection) {
			if (filter.include(t)) {
				return t;
			}
		}
		return null;
	}*/

	public static String padStringToDigits(String value, Integer padToDigits) {

		if (value == null)
			return null;

		StringBuilder finalValue = new StringBuilder(value);
		int length = finalValue.length();
		if (length < padToDigits) {
			prependZeroes(padToDigits - length, finalValue);
		}

		return finalValue.toString();

	}

	public static void prependZeroes(int noOfZeroes, StringBuilder value) {

		for (int i = 0; i < noOfZeroes; i++) {
			value.insert(0, "0");
		}
	}

	/**
	* Replaces string in the pattern with supplied string
	* 
	* @param str
	*            String - string to be replaced
	* @param pattern
	*            String - pattern of the string
	* @param replace
	*            String - string to be replaced
	* @return Modified string
	*/
	public static final String replace(String str, String pattern, String replace) {

		int slen = str.length();
		int plen = pattern.length();
		int s = 0, e = 0;
		StringBuffer result = new StringBuffer(slen * 2);
		char[] chars = new char[slen];

		while ((e = str.indexOf(pattern, s)) >= 0) {
			str.getChars(s, e, chars, 0);
			result.append(chars, 0, e - s).append(replace);
			s = e + plen;
		}
		str.getChars(s, slen, chars, 0);
		result.append(chars, 0, slen - s);
		return result.toString();
	}

	public static int getDateField(Date date, String field) {

		int result = 0;

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);

		if (field.equalsIgnoreCase("day")) {
			result = calendar.get(Calendar.DAY_OF_MONTH);
		} else if (field.equalsIgnoreCase("month")) {
			result = calendar.get(Calendar.MONTH);
		} else if (field.equalsIgnoreCase("year")) {
			result = calendar.get(Calendar.YEAR);
		}
		return result;

	}

	public static boolean stringExistsInArray(String value, String[] arrString) {

		for (int i = 0; i < arrString.length; i++)
			if (arrString[i].trim().equals(value.trim()))
				return true;
		return false;
	}

	/**
	* Returns the display end date year
	* 
	* @return java.lang.String the end year to be displayed
	*/


	/**
	* Returns the display start date year
	* 
	* @return java.lang.String the start year to be displayed
	*/
	public static String getDisplayStartYear() {

		return (Calendar.getInstance().get(Calendar.YEAR) + "");
	}

	/**
	* Returns the current month
	* 
	* @return java.lang.String the current month
	*/
	public static String getCurrentMonth() {

		return (Calendar.getInstance().get(Calendar.MONTH) + "");
	}

	/**
	* This method converts a null string to blank.
	* 
	* @return java.lang.String VConverted string
	* @param str
	*            String
	*/
	public static String convertNull(String str) {

		if (str == null)

			return "";
		else
			return replace(str.trim(), "\"", "");
	}

	public static Integer getMonthFromDate(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		Integer month = cal.get(Calendar.MONTH);
		month++;
		return month;
	}

	public static Integer getYearFromDate(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		Integer year = cal.get(Calendar.YEAR);
		return year;
	}

	public static Integer getDayFromDate(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		Integer year = cal.get(Calendar.DATE);
		return year;
	}



	public static String trimStringToLength(String value, int length) {
		return null == value ? "" : value.length() < length ? value : value.substring(0, length);
	}

	public static boolean isValidDate(String dateToValidate, String dateFromat) {
		if (dateToValidate == null) {
			return false;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(dateFromat);
		sdf.setLenient(false);
		try {
			Date date = sdf.parse(dateToValidate);
			System.out.println(date);
		} catch (ParseException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public static Date subtractDaystoDate(Date dateInstance, int daysTosubtract) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(dateInstance);
		cal.add(Calendar.DATE, -daysTosubtract);
		return cal.getTime();
	}

	

	public static BigInteger stringToBigInt(String value) {
		BigInteger bigInt = null;
		if (!isEmpty(value)) {
			bigInt = new BigInteger(value);
		}
		return bigInt;
	}

	public static BigInteger[] stringArrayToBigIntArray(String[] valueArr) {
		BigInteger[] bigInt = null;
		if (null != valueArr) {
			bigInt = new BigInteger[valueArr.length];
			for (int i = 0; i < valueArr.length; i++) {
				bigInt[i] = new BigInteger(valueArr[i]);
			}
		}
		return bigInt;
	}



	// Authorize Partner
	public static Calendar stringToCalender(String dateString, String dateFormat) throws Exception {
		Calendar calendar = Calendar.getInstance();
		Date date = stringToDate(dateString, dateFormat);
		calendar.setTime(date);
		return calendar;
	}

	public static String getDate(int day, int month, int year) {

		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String strDate;
		calendar.set(Calendar.DAY_OF_MONTH, day);
		calendar.set(Calendar.MONTH, month);
		calendar.set(Calendar.YEAR, year);
		// use date format
		strDate = formatter.format(calendar.getTime());

		return strDate;
	}

	public static final boolean compareDates(Date firstDate, Date secondDate) {

		if (getMonthFromDate(firstDate) == getMonthFromDate(secondDate)) {
			if (getYearFromDate(firstDate) == getYearFromDate(secondDate)) {
				if (getDayFromDate(firstDate) == getDayFromDate(secondDate)) {
					return true;
				}
			}
		}
		return false;
	}

	public static String intToString(int value) {
		return Integer.toString(value);
	}

	public static String getMonthNameFromNumber(int monthNumber) {
		Map<Integer, String> monthdetails = new TreeMap<Integer, String>();
		monthdetails.put(1, "January");
		monthdetails.put(2, "February");
		monthdetails.put(3, "March");
		monthdetails.put(4, "April");
		monthdetails.put(5, "May");
		monthdetails.put(6, "June");
		monthdetails.put(7, "July");
		monthdetails.put(8, "August");
		monthdetails.put(9, "September");
		monthdetails.put(10, "October");
		monthdetails.put(11, "November");
		monthdetails.put(12, "December");
		return monthdetails.get(monthNumber);
	}

	public static String dateToMonthYear(Date date) {
		String month = CommonUtil.dateToString(date, "MMMM");
		String year = CommonUtil.dateToString(date, "YYYY");
		String monthYear = month.concat(" ").concat(year);
		return monthYear;
	}

	public static Date stringToEndDateWithMonthAndYear(String month, String year) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_MONTH, 0);
		calendar.set(Calendar.MONTH, stringToInt(month));
		calendar.set(Calendar.YEAR, stringToInt(year));
		return calendar.getTime();
	}

	public static Date stringToStartDateWithMonthAndYear(String month, String year) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		calendar.set(Calendar.MONTH, stringToInt(month) - 1);
		calendar.set(Calendar.YEAR, stringToInt(year));
		return calendar.getTime();
	}

	public static boolean hasSpaces(String str) {

		StringTokenizer st = new StringTokenizer(str, " ");
		if (st.countTokens() > 1)
			return true;
		else
			return false;
	}

	public static String monthYearToString(String year, String month) {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		calendar.set(Calendar.MONTH, Integer.parseInt(month) - 1);
		calendar.set(Calendar.YEAR, Integer.parseInt(year));
		String date = formatter.format(calendar.getTime());
		return date;
	}

	public static Date monthYearToDateOfdayMaximum(String year, String month) throws ParseException {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		calendar.set(Calendar.YEAR, Integer.parseInt(year));
		calendar.set(Calendar.MONTH, Integer.parseInt(month) - 1);
		calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
		String strDate = formatter.format(calendar.getTime());
		Date date = formatter.parse(strDate);
		return date;

	}



	public static final int getDateFieldForSE(Date date, String field) {

		int result = 0;

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);

		if (field.equalsIgnoreCase("day")) {
			result = calendar.get(Calendar.DAY_OF_MONTH);
		} else if (field.equalsIgnoreCase("month")) {
			result = calendar.get(Calendar.MONTH);
		} else if (field.equalsIgnoreCase("year")) {
			result = calendar.get(Calendar.YEAR);
		}
		return result;

	}

	public static final String getPartnerStatus(String statusCode) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("01", "ACTIVE");
		map.put("02", "READY TO AUTHORISE");
		map.put("03", "NEW");
		map.put("04", "CANCELLED");
		map.put("05", "TERMINATED");
		statusCode = CommonUtil.convertNull(statusCode);
		String statusDesc = CommonUtil.convertNull(map.get(statusCode));
		return statusDesc;
	}


	public static final String getIssueSts(String issueStatusVal) {
		String issueStatus = null;
		if (issueStatusVal.equals("01")) {
			issueStatus = "OPEN";

		} else if (issueStatusVal.equals("02")) {
			issueStatus = "UNDER CORRECTION";
		}
		if (issueStatusVal.equals("03")) {
			issueStatus = "IGNORE";
		}
		if (issueStatusVal.equals("04")) {
			issueStatus = "CORRECTED";
		}
		if (issueStatusVal.equals("05")) {
			issueStatus = "UNDER REVALIDATION";
		}
		if (issueStatusVal.equals("06")) {
			issueStatus = "NONE";
		}
		return issueStatus;
	}

	public static String getCurrentDate() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		return dateFormat.format(new Date());
	}

	public static Date stringToDateAndFormatIt(String dateString, String dateFormat) throws Exception {
		Date date = null;
		try {
			if (dateString != null) {
				DateFormat formatter;
				formatter = new SimpleDateFormat(dateFormat);
				date = (Date) formatter.parse(dateString);
				System.out.println(date.toString());
				Calendar calendar = new GregorianCalendar();
				System.out.println(calendar);
				System.out.println(calendar.getTime());
			}
		} catch (ParseException e) {
			logger.error("Strin to date parser exception ", e);
			throw new Exception(e.getMessage());
		}
		return date;
	}

	/*
	* GNA Web Service Implementation. Date: 18-May-2016
	*/

	public static int bigIntegerToInt(BigInteger bigInteger) {
		int intVal = 0;
		if (null != bigInteger) {
			intVal = bigInteger.intValue();
		}
		return intVal;
	}

	public static boolean isEmpty(Map<?, ?> map) {
		return (map == null || map.isEmpty());
	}

	/*
	* End
	*/
	/****
	* @author Suday_Rajendran Optimized This method pads spaces with the given string using string utils
	* @param strToBePadded
	* @param spaceLength
	* @return
	*/


	/****
	* @author Suday_Rajendran This method gets string for given date and format
	* @param stringToPad
	* @param totalLength
	* @return String
	*/
	public static String datetoString(Date date, String format) {
		String convertedDate = null;
		if (date != null) {
			DateFormat df = new SimpleDateFormat(format);
			convertedDate = df.format(date);
		}
		return convertedDate;
	}

	public static boolean validateRegex(String value, String regex) {
		if (!StringUtils.isEmpty(value)) {
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(value);
			return matcher.matches();
		}
		return false;
	}

	/***
	* @author Suday_Rajendran Optimized this method preappends zeros to the given string using String Utils
	* @param strToBePadded
	* @param iStringLength
	* @return
	*/


	// --user level reminder start---//
	public static Calendar currentDateIST() throws Exception {
		TimeZone timeZone = TimeZone.getTimeZone("IST");
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSSSS");
		format.setTimeZone(timeZone);
		Calendar currentISTTime = new GregorianCalendar();
		currentISTTime.setTime(CommonUtil.stringToDate(format.format(new Date()), "yyyy-MM-dd"));
		return currentISTTime;

	}

	public static boolean dateBeforeCurrentDate(Calendar todaysDateCAL, String strdate) throws Exception {
		Date todaysDate = todaysDateCAL.getTime();
		Date dateFromDb = CommonUtil.stringToDate(strdate, "MM/dd/yyyy");

		if (dateFromDb.before(todaysDate)) {
			return true;
		}
		return false;

	}

	// --user level reminder end---//

	// Airport Lounge
	public static boolean isAlphaNumeric(String s) {

		char[] sChars = s.toCharArray();
		for (int i = 0; i < sChars.length; i++) {
			if (!(Character.isLetter(sChars[i]) || Character.isDigit(sChars[i])))
				return false;
		}

		return true;
	}

	public static boolean isAlphabetOrSpace(String s) {

		char[] sChars = s.toCharArray();
		for (int i = 0; i < sChars.length; i++) {
			if (!(Character.isLetter(sChars[i]) || Character.isSpaceChar(sChars[i])))
				return false;
		}

		return true;
	}

	public static String fileExtention(String fileName) {
		String extension = "";
		int i = fileName.lastIndexOf('.');
		if (i > 0) {
			extension = fileName.substring(i + 1);
		}
		return extension;
	}


	public static boolean isFutureDate(Date dtStrtDate) throws ParseException {

		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		logger.debug("Date from the form");
		Calendar cal = Calendar.getInstance();
		String presentdate = dateFormat.format(cal.getTime());
		logger.debug("presentdate" + presentdate);
		Date presntDate = (Date) dateFormat.parse(presentdate);

		if (presntDate.compareTo(dtStrtDate) < 0) {
			logger.debug("The Start date is after present date");
			return true;

		} else {
			logger.debug("The Start date is not greater than the present date");
			return false;
		}

	}

	public static boolean validateTime(String strTime, String separator) {

		boolean flag = true;
		try {

			StringTokenizer stok = new StringTokenizer(strTime, separator);

			if (stok.countTokens() != 3) {
				flag = false;
				return flag;
			}
			int hour = Integer.parseInt(stok.nextToken().trim());
			int min = Integer.parseInt(stok.nextToken().trim());
			int sec = Integer.parseInt(stok.nextToken().trim());
			if (hour >= 0 && hour <= 23 && min >= 0 && min <= 59 && sec >= 0 && sec <= 59) {
				flag = true;
			} else {
				flag = false;
			}
		} catch (Exception exp) {
			flag = false;
		}
		return flag;

	}

	public static boolean isAlphabetic(String s) {

		char[] sChars = s.toCharArray();
		for (int i = 0; i < sChars.length; i++)
			if (!Character.isLetter(sChars[i]))
				return false;
		return true;
	}

	public static Date addDaystoDate(Date dateInstance, int daysToAdd) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(dateInstance);
		cal.add(Calendar.DATE, +daysToAdd);
		return cal.getTime();
	}

	public static int differenceBt2Dates(Date date1, Date date2) {
		Calendar from = Calendar.getInstance();
		from.setTime(date1);
		Calendar to = Calendar.getInstance();
		to.setTime(date2);
		to.set(Calendar.YEAR, from.get(Calendar.YEAR));
		int fromDAY = from.get(Calendar.DAY_OF_YEAR);
		int toDAY = to.get(Calendar.DAY_OF_YEAR);
		int diffDay = toDAY - fromDAY;
		return diffDay;
	}

	public static Calendar calGetCurrentDate() {

		Calendar gcCurrDate = null;
		String strDelimiter = "/";

		String strCurrDate = "";
		if (strCurrDate == null || strCurrDate.equals("")) {
			gcCurrDate = Calendar.getInstance();
		} else {
			StringTokenizer stok = new StringTokenizer(strCurrDate, strDelimiter);

			int intDay = Integer.parseInt(stok.nextToken().trim());
			int intMonth = Integer.parseInt(stok.nextToken().trim());
			int intYear = Integer.parseInt(stok.nextToken().trim());

			gcCurrDate = new GregorianCalendar(intYear, intMonth, intDay);
		}

		return gcCurrDate;
	}

	public static boolean doubleValueHasChars(String value) {

		try {
			Double.parseDouble(value);
		} catch (NumberFormatException ex) {
			return true;
		}
		return false;
	}

	public static int differenceBt2DatesAutoReminder(Date date1, Date date2) {
		int diffDay = (int) ((date2.getTime() - date1.getTime()) / (1000 * 60 * 60 * 24));
		return diffDay;
	}

	public static final String getAgingCd(String agingCd) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("0", "000");
		map.put("1", "030");
		map.put("2", "060");
		map.put("3", "090");
		map.put("4", "120");
		map.put("5", "150");
		map.put("6", "180");
		map.put("7", "210");
		map.put("8", "240");
		map.put("9", "270");
		String agingDesc = map.get(agingCd);
		return agingDesc;
	}

	// if date is yyyyMMdd its appends to yyyy-MM-dd
	public static String hyfenAppendInDate(String st) {
		st = st.substring(0, 4) + "-" + st.substring(4, 6) + "-" + st.substring(6, 8);
		return st;
	}

	public static Calendar setTimeToCalendar(String dateFormat, String date, boolean addADay) throws ParseException {
		Date time = new SimpleDateFormat(dateFormat).parse(date);
		Calendar cal = Calendar.getInstance();
		cal.setTime(time);

		if (addADay) {
			cal.add(Calendar.DATE, 1);
		}
		return cal;
	}
	public static double roundingTo2Decimals(Double dblnbr){
		return Math.round (dblnbr * 100.0) / 100.0;
		
	}

	public static List<Integer> getPageNoList(int tot) {
		List <Integer> pageNoList = new ArrayList<Integer>();
		for(int i=1;i<=tot;i++){
			pageNoList.add(i);
		}
		return pageNoList;
	}
}