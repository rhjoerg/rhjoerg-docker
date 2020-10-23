package ch.rhjoerg.docker.maven;

import java.nio.file.Files;
import java.nio.file.Path;

public class MavenServer
{
	public static void main(String[] args)
	{
		try
		{
			Path dataPath = Path.of("/data");

			Files.walk(dataPath).forEach(p -> System.out.println(p));
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
