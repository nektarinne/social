/*
 * Copyright 2021-2021 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package pro.tremblay.social.uat;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pro.tremblay.social.util.ConsoleTestingDSL;
import pro.tremblay.social.util.TestContext;

import static org.assertj.core.api.Assertions.assertThat;

public class StartAndStopSteps {

	TestContext testContext;

	public StartAndStopSteps(TestContext context) {
		testContext = context;
	}

	@When("^the application receives an 'exit' command$")
	public void when_the_application_receives_an_exit_command() {
		testContext.console()
				   .sendUserCommand("some user command");
		testContext.console()
				   .sendUserCommand("exit");
	}

	@Then("^the application should terminate:$")
	public void then_the_application_should_terminate(String expected) {
		String output = testContext.console()
								   .retrieveOutput();
		assertThat(output).isEqualTo(expected.replace("\n", "\r\n"));
	}

}
