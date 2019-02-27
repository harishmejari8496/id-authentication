package io.mosip.registration.processor.packet.receiver.builder;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.mosip.kernel.core.util.DateUtils;
import io.mosip.registration.processor.packet.receiver.dto.PacketReceiverResponseDTO;
import io.mosip.registration.processor.packet.receiver.dto.ResponseDTO;

@Component
public class PacketReceiverResponseBuilder{
	
	
	/**
	 * Builds the packet receiver exception response.
	 *
	 * @param ex the ex
	 * @return the string
	 */
	public static String buildPacketReceiverResponse(String statusCode,List<String> l) {

		PacketReceiverResponseDTO response = new PacketReceiverResponseDTO();
		if (Objects.isNull(response.getId())) {
			response.setId(l.get(0));
		}
		response.setError(null);
		response.setResponseTimestamp(DateUtils.getUTCCurrentDateTimeString(l.get(1)));
		response.setVersion(l.get(2));
		ResponseDTO responseDTO=new ResponseDTO();
		responseDTO.setStatus(statusCode);
		response.setResponse(responseDTO);
		Gson gson = new GsonBuilder().serializeNulls().create();
		return gson.toJson(response);
	}

}
