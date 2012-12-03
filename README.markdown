## vraptor-freemarker
![Build status](https://secure.travis-ci.org/caelum/vraptor-freemarker.png)

A simple freemarker engine for rendering templates from within jar files, or rendering email etc.

# installing

Vraptor-freemarker.jar can be downloaded from maven's repository, or configured in any compatible tool:

		<dependency>
			<groupId>br.com.caelum.vraptor</groupId>
			<artifactId>vraptor-freemarker</artifactId>
			<version>1.1.0</version>
			<scope>compile</scope>
		</dependency>


# usage for rendering pages

		@Resource
		public class DashboardController {

			private final User user;
			private final Freemarker freemarker;

			public DashboardController(User user, Freemarker freemarker) {
				this.user = user;
				this.freemarker = freemarker;
			}

			@Path("/admin/dashboard")
			@Get
			public void list() throws IOException, TemplateException {
				freemarker.use("dashboard").with("currentUser", user).render();
			}

		}

# or...

		@Resource
		public class DashboardController {

			private final User user;
			private final Result result;

			public DashboardController(User user, Result result) {
				this.user = user;
				this.result = result;
			}

			@Path("/admin/dashboard")
			@Get
			public void list() throws IOException, TemplateException {
				result.include("currentUser", user);
				result.use(FreemarkerView.class).withTemplate("dashboard");
			}

		}

# usage for rendering emails

		String body = freemarker.use("send_mail_notification").with("currentUser", user).getContent();

# usage when testing

		@Test
		public void testSomething() throws Exception {
			new DashboardController(new User(), new MockFreemarker()).list();
			// your assertions here
		}

# help

Get help from vraptor developers and the community at vraptor mailing list.
