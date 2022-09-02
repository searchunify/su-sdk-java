# SearchUnify SDK

## Overview
The SearchUnify SDK for Java enabled Java developers to easily work with the SearchUnify platform and build scalable solutions with search, analytics, crawlers and more. You can get started in minutes using Maven or by downloading the JAR file
The SearchUnify SDK for Java simpliﬁes use of SearchUnify Services by providing a set of libraries that are consistent and familiar for Java developers. It provides support for API lifecycle consideration such as credential management, retries, data marshaling, and serialization. The SearchUnify SDK for Java also supports higher level abstractions for simplified development.

## Key Features
* HTTP/2 Support and pluggable HTTP layer, new programming interfaces seamlessly take advantage of HTTP/2 features and provide new ways to build applications.
* Nonblocking I/O, the SearchUnify SDK for Javascript utilizes a new, nonblocking SDK architecture to support true nonblocking I/O. It features truly non blocking asynchronous clients that implement high concurrency across a few threads.

## Getting Started
Sign up for SearchUnify, before you begin, you need a SearchUnify account. Please see the oAuth section of the developer guide for information about how to retrieve your SearchUnify credentials.

## Installation
SDK requires JDK 1.8+ and Maven 3.0 to run.
The recommended way to use the SearchUnify SDK for Java in your project is to consume it from Maven. Import the JAR and specify the SDK Maven modules that your project needs in the dependencies.
```java
<dependencies>
  <dependency>
    <groupId>com.searchunify</groupId>
    <artifactId>su-sdk</artifactId>
    <version>1.0.0</version>
  </dependency>
</dependencies>
```
## Execution
Initiate SearchUnify Java SDK on Server. Using the SDK, you can route search requests. To start using, initialize the SDK with your URL and API key.
```java
import com.searchunify.sdk.SearchUnifyClient;

public class App {

	private SearchUnifyClient client;

	public App() {
		String key = "key";
		String secret = "secret";
		String baseContext = "https://feature4.searchunify.com";
		String username = "changeme";
		String password = "changeme";
		this.client = new SearchUnifyClient(key, secret, baseContext, username, password, "password");
	}
}
```
The access token will expire after 4 hours and you need to refresh that.

## Documentation
Please refer to the SearchUnify developer guide to use the SDK. https://docs-dev.searchunify.com/Content/Developer-Guides/SDKs-Java.htm

The documentations are in review phase, we will update the https://docs.searchunify.com link once its's final. Sorry for any BUGS 🐞.

## License

MIT

**&copy; Powered by [SearchUnify](https://www.searchunify.com/)!**
