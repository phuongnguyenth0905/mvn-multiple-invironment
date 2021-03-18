package commons;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Key;
import org.aeonbits.owner.Config.Sources;

@Sources({"classpath:${environment}.properties"})
public interface Environment extends Config {
	String url();
	
	@Key("db.hostname")
	String getDBHostname();
	
	@Key("db.username")
	String getDBUsername();
	
	@Key("db.password")
	String getDBPassword();
	
}
