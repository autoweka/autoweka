
package autoweka;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

import javax.xml.bind.annotation.*;

/*
Simply a wrapper for a list of configurations. Might seem silly and redundant, but the purpose of this is to work nicely with the XML Parser that already exists in AutoWeka.
Also contains the static methods for organizing,sorting and spitting them out to an output file after autoweka is finished running
*/
@XmlRootElement(name="configurationCollection")
public class ConfigurationCollection extends XmlSerializable{

	@XmlElement(name="configurations")
	private ArrayList<Configuration> mConfigurations;

	public ConfigurationCollection(){
		mConfigurations = new ArrayList<Configuration>();
	}
	public ConfigurationCollection(List<Configuration> aConfigurations){
		mConfigurations = new ArrayList<Configuration> (aConfigurations);
	}
	public ConfigurationCollection(ArrayList<Configuration> aConfigurations){
		mConfigurations = aConfigurations;
	}
	public void add(Configuration c){
		mConfigurations.add(c);
	}
	public ArrayList<Configuration> asArrayList(){
		return mConfigurations;
	}
	public static <T extends XmlSerializable> T fromXML(String filename, Class<T> c){ //Original is protected so we're overriding to make it public.
		return XmlSerializable.fromXML(filename,c);
	}

}
