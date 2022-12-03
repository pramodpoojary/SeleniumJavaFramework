package pramodpoojary.data;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class dataReader {

	public List<HashMap<String, String>> getJsonDataToMap() throws IOException {
		// reading json to string
		String jsoneContentString = FileUtils.readFileToString(
				new File(System.getProperties() + "\\src\\test\\java\\pramodpoojary\\data\\purhcaseorder.json"),
				StandardCharsets.UTF_8);
		// string to hashmap json databind
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(jsoneContentString,
				new TypeReference<List<HashMap<String, String>>>() {
				});
		return data;
	}
}
