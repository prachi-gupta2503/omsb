package omsb.vehpc.equivalency.util;

import com.liferay.petra.string.StringPool;

import java.util.HashMap;
import java.util.Map;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
@Component(immediate = true, service = HeaderUtil.class)
public class HeaderUtil {

	/**
	 * @author SachinG
	 * @return This method returns Authorization and Content-Type 
	 */
	 public  Map<String, String> getHeaders() {
		 return omsbCommonApi.getHttpHeaderInfoAndBasicAuth();
		/*
		 * Map<String, String> headers = new HashMap<>(); String tokenAuth =
		 * omsbCommonApi.getHttpHeaderInfoAndBasicAuth(); //
		 * headers.put("Authorization", "bearer"+StringPool.SPACE+
		 * "eyJ0eXAiOiJhdCtqd3QiLCJhbGciOiJSUzI1NiJ9.eyJqdGkiOiI3OWUxNGRjMThlYTU5ZmE1YTIyNDU4YTFhZDYzZDQ0MzkxMWE0ZGRhZjNiNmU0YjkyODViNmEzZTQ0OGZjZSIsImNsaWVudF9pZCI6ImlkLTFkZTMzNmJkLWRjMmMtN2E1NS05MjhlLTQ5Nzc2M2MzZDJmIiwiaWF0IjoxNjkwNDYxNzI4LCJleHAiOjE2OTA1NDgxMjgsInN1YiI6IjIwMjIzIiwidXNlcm5hbWUiOiJ0ZXN0IiwiaXNzIjoibG9jYWxob3N0Iiwic2NvcGUiOiJDX0VxdWl2YWxlbmN5QXBwZWFsU3RhdHVzLmV2ZXJ5dGhpbmcgQ19QZXJzb25hbERldGFpbC5ldmVyeXRoaW5nLndyaXRlIENfRW1wbG95bWVudERldGFpbC5ldmVyeXRoaW5nLndyaXRlIENfRG9jdW1lbnRUeXBlQ29tcG9uZW50UmVsLmV2ZXJ5dGhpbmcucmVhZCBDX0hlYWx0aExpY2Vuc2VEZXRhaWwuZXZlcnl0aGluZy53cml0ZSBDX0V4YW1SZWdpc3RyYXRpb24uZXZlcnl0aGluZyBDX0V4YW1XaXRoZHJhd2FsRG9jdW1lbnRzLmV2ZXJ5dGhpbmcgQ19Nb2RlT2ZTdHVkeS5ldmVyeXRoaW5nLndyaXRlIENfRXF1aXZhbGVuY3lSZXF1ZXN0LmV2ZXJ5dGhpbmcgQ19DYXNlU3RhdHVzLmV2ZXJ5dGhpbmcud3JpdGUgQ19FcXVpdmFsZW5jeVJlcXVlc3RTdGF0dXMuZXZlcnl0aGluZy5yZWFkIENfRXF1aXZhbGVuY3lSZXF1ZXN0LmV2ZXJ5dGhpbmcud3JpdGUgQ19FcXVpdmFsZW5jeURlY2lzaW9uTGV2ZWwuZXZlcnl0aGluZy5yZWFkIENfQ3VzdG9tQ291bnRyeS5ldmVyeXRoaW5nLndyaXRlIENfQ2FzZVJlcXVlc3RTdGFnZS5ldmVyeXRoaW5nIENfQ2FzZVJlcXVlc3RTdGFnZS5ldmVyeXRoaW5nLnJlYWQgQ19QZXJzb24uZXZlcnl0aGluZyBDX0VxdWl2YWxlbmN5RGVjaXNpb24uZXZlcnl0aGluZyBDX0V4YW1SZWd1bGFyRmVlcy5ldmVyeXRoaW5nIER5bmFtaWNGb3JtQnVpbGRlckhlYWRsZXNzLmV2ZXJ5dGhpbmcgQ19Eb2N1bWVudFR5cGUuZXZlcnl0aGluZy53cml0ZSBDX0VxdWl2YWxlbmN5RG9jdW1lbnRUeXBlLmV2ZXJ5dGhpbmcud3JpdGUgQ19FcXVpdmFsZW5jeURlY2lzaW9uTGV2ZWwuZXZlcnl0aGluZyBDX0V4YW1FbGlnaWJpbGl0eU1hcHBpbmcuZXZlcnl0aGluZyBDX0VtcGxveW1lbnREZXRhaWwuZXZlcnl0aGluZyBDX0Nhc2VTdGFnZS5ldmVyeXRoaW5nLndyaXRlIENfRWR1Y2F0aW9uRGV0YWlsLmV2ZXJ5dGhpbmcud3JpdGUgQ19QZXJzb24uZXZlcnl0aGluZy53cml0ZSBDX0Nhc2VSZXBvcnQuZXZlcnl0aGluZyBDX01vZGVPZlN0dWR5LmV2ZXJ5dGhpbmcgQ19SZWZlcmVuY2lhbERldGFpbC5ldmVyeXRoaW5nLndyaXRlIENfQ2FzZVN0YXR1cy5ldmVyeXRoaW5nIENfRXF1aXZhbGVuY3lEZWNpc2lvbi5ldmVyeXRoaW5nLndyaXRlIENfRXF1aXZhbGVuY3lEb2N1bWVudFR5cGUuZXZlcnl0aGluZyBDX0N1c3RvbUNvdW50cnkuZXZlcnl0aGluZy5yZWFkIENfQ29tcG9uZW50LmV2ZXJ5dGhpbmcud3JpdGUgQ19FcXVpdmFsZW5jeUFwcGVhbC5ldmVyeXRoaW5nLnJlYWQgQ19DYXNlU3RhZ2UuZXZlcnl0aGluZyBDX1JlZmVyZW5jaWFsRGV0YWlsLmV2ZXJ5dGhpbmcucmVhZCBDX0V4YW1BcHBlYWxEb2N1bWVudHMuZXZlcnl0aGluZyBDX0N1c3RvbUNvdW50cnkuZXZlcnl0aGluZyBDX1BheW1lbnREZXRhaWwuZXZlcnl0aGluZy53cml0ZSBDX0VxdWl2YWxlbmN5Q2VydGlmaWNhdGUuZXZlcnl0aGluZy53cml0ZSBDX1BlcnNvbi5ldmVyeXRoaW5nLnJlYWQgQ19Eb2N1bWVudFR5cGVDb21wb25lbnRSZWwuZXZlcnl0aGluZyBDX0Nhc2VUeXBlLmV2ZXJ5dGhpbmcgQ19FcXVpdmFsZW5jeVJlcXVlc3RTdGF0dXMuZXZlcnl0aGluZyBDX0VxdWl2YWxlbmN5UmVxdWVzdC5ldmVyeXRoaW5nLnJlYWQgQ19DYXNlUmVxdWVzdFN0YWdlLmV2ZXJ5dGhpbmcud3JpdGUgQ19Eb2N1bWVudFR5cGUuZXZlcnl0aGluZy5yZWFkIER5bmFtaWNGb3JtQnVpbGRlckhlYWRsZXNzLmV2ZXJ5dGhpbmcucmVhZCBDX0V4YW1XaXRoZHJhd2FsU3RhdHVzLmV2ZXJ5dGhpbmcgQ19FeGFtU2NoZWR1bGUuZXZlcnl0aGluZyBEeW5hbWljRm9ybUJ1aWxkZXJIZWFkbGVzcy5ldmVyeXRoaW5nLndyaXRlIENfRXF1aXZhbGVuY3lBcHBlYWwuZXZlcnl0aGluZyBDX1BlcnNvbmFsRGV0YWlsLmV2ZXJ5dGhpbmcgQ19DYXNlVHlwZS5ldmVyeXRoaW5nLnJlYWQgQ19Eb2N1bWVudEluZm8uZXZlcnl0aGluZy5yZWFkIENfRXhhbUFwcGVhbFN0YXR1cy5ldmVyeXRoaW5nIENfRXhhbVR5cGUuZXZlcnl0aGluZyBDX0Nhc2VTdGFnZS5ldmVyeXRoaW5nLnJlYWQgQ19FbXBsb3ltZW50RGV0YWlsLmV2ZXJ5dGhpbmcucmVhZCBDX0V4YW1BcHBlYWwuZXZlcnl0aGluZyBDX0RvY3VtZW50VHlwZUNvbXBvbmVudFJlbC5ldmVyeXRoaW5nLndyaXRlIENfRWR1Y2F0aW9uRGV0YWlsLmV2ZXJ5dGhpbmcgQ19DYXNlUmVxdWVzdC5ldmVyeXRoaW5nIENfRXhhbVJlc3VsdC5ldmVyeXRoaW5nIENfQ29tcG9uZW50LmV2ZXJ5dGhpbmcgQ19FcXVpdmFsZW5jeUFwcGVhbFN0YXR1cy5ldmVyeXRoaW5nLndyaXRlIENfRG9jdW1lbnRJbmZvLmV2ZXJ5dGhpbmcud3JpdGUgQ19DYXNlVHlwZS5ldmVyeXRoaW5nLndyaXRlIENfQ29tcG9uZW50LmV2ZXJ5dGhpbmcucmVhZCBDX0VxdWl2YWxlbmN5Q2VydGlmaWNhdGUuZXZlcnl0aGluZy5yZWFkIENfSGVhbHRoTGljZW5zZURldGFpbC5ldmVyeXRoaW5nIENfQ2FzZVJlcG9ydC5ldmVyeXRoaW5nLndyaXRlIENfRXF1aXZhbGVuY3lBcHBlYWxTdGF0dXMuZXZlcnl0aGluZy5yZWFkIENfRW1lcmdlbmN5Q29udGFjdC5ldmVyeXRoaW5nIENfRG9jdW1lbnRUeXBlLmV2ZXJ5dGhpbmcgQ19FeGFtV2l0aGRyYXdhbC5ldmVyeXRoaW5nIENfRXhhbS5ldmVyeXRoaW5nIENfRXF1aXZhbGVuY3lEb2N1bWVudFR5cGUuZXZlcnl0aGluZy5yZWFkIENfUGF5bWVudERldGFpbC5ldmVyeXRoaW5nIENfQ2FzZVN0YXR1cy5ldmVyeXRoaW5nLnJlYWQgQ19SZWZlcmVuY2lhbERldGFpbC5ldmVyeXRoaW5nIENfRXF1aXZhbGVuY3lBcHBlYWwuZXZlcnl0aGluZy53cml0ZSBDX1BlcnNvbmFsRGV0YWlsLmV2ZXJ5dGhpbmcucmVhZCBDX0Nhc2VSZXF1ZXN0LmV2ZXJ5dGhpbmcucmVhZCBDX0V4YW1EZWZpbml0aW9uLmV2ZXJ5dGhpbmcgQ19FcXVpdmFsZW5jeURlY2lzaW9uTGV2ZWwuZXZlcnl0aGluZy53cml0ZSBDX1BheW1lbnREZXRhaWwuZXZlcnl0aGluZy5yZWFkIENfRXF1aXZhbGVuY3lDZXJ0aWZpY2F0ZS5ldmVyeXRoaW5nIENfQ2FzZVJlcXVlc3QuZXZlcnl0aGluZy53cml0ZSBDX0VkdWNhdGlvbkRldGFpbC5ldmVyeXRoaW5nLnJlYWQgQ19DYXNlUmVwb3J0LmV2ZXJ5dGhpbmcucmVhZCBDX0RvY3VtZW50SW5mby5ldmVyeXRoaW5nIENfTW9kZU9mU3R1ZHkuZXZlcnl0aGluZy5yZWFkIENfRXF1aXZhbGVuY3lEZWNpc2lvbi5ldmVyeXRoaW5nLnJlYWQgQ19FeGFtTXVsdGlEYXRlcy5ldmVyeXRoaW5nIENfRXF1aXZhbGVuY3lSZXF1ZXN0U3RhdHVzLmV2ZXJ5dGhpbmcud3JpdGUiLCJncmFudF90eXBlIjoiY2xpZW50X2NyZWRlbnRpYWxzIn0.EKv8G4Wn1h1OZuUWOjdJY8KL0liDcveyC_EJo8Or4oXOxPRKCa7zcnelXejKdrY_uimPS3T8SCFPRADQi8wkPJ8TiB1g0FxXRKHBFWQ89KQSMRYfiT11qbZtwJEbOxtEn2319NKhEu5F3QlFb2vH8RUtRzk2tJgmLdivUcEHJ2e8KZIAzX8pi6TrEsXaLR_7s4INXTq-xoClyIPSfXIQQbhxj_dcFRkyusEEaSpeoXEqyKSrpkVrxSarRieZaUjQJv7Vkh5gEqtULUfa_8_OXfP2Ls7LtX7lEA7hG3dyrCJl9I8WRysOru0MML-qg5fKPNlyyWLvjacRUEt3dUqY5g"
		 * ); headers.put("Authorization", "bearer"+StringPool.SPACE+ tokenAuth);
		 * headers.put("Content-Type", "application/json"); return headers;
		 */
	 }
	 
		@Reference(unbind = "-")
		private OMSBCommonApi omsbCommonApi;
	 
}

