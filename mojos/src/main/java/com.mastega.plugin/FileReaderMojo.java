package com.mastega.plugin;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.plugin.descriptor.MojoDescriptor;
import org.apache.maven.plugins.annotations.LifecyclePhase;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/*
@Parameter( property = "sayhi.greeting", defaultValue = "Hello World!" )
private String greeting
*/
@Mojo(name = "read-file", defaultPhase = LifecyclePhase.COMPILE, threadSafe = true)
public class FileReaderMojo extends AbstractMojo
{

    @Parameter(defaultValue = "Hello, world!")
    private String filename;

    public void execute() throws MojoExecutionException
    {
      getLog().info(filename);
      BufferedReader reader;
      try {
  			reader = new BufferedReader(new FileReader(
        filename
        ));
  			String line = reader.readLine();
  			while (line != null) {
  				getLog().info(line);
  				// read next line
  				line = reader.readLine();
  			}
  			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
}
