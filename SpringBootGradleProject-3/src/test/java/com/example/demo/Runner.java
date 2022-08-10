package com.example.demo;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/main/resources/FirstFeature.feature",dryRun=false,
glue = {"com.example.demo"},
monochrome = true
)
public class Runner {

}
