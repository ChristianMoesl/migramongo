package com.rinoto.migramongo;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = { MigraMongoTestConfig.class, InitialMigScript.class, MigScript1.class })
@RunWith(SpringJUnit4ClassRunner.class)
public class MigraMongoTest {

	@Autowired
	private MigraMongo migraMongo;

	@Test
	public void shouldMigrateInitialAndMigScript1() {
		// when
		final MigraMongoStatus migrate = migraMongo.migrate();
		// then
		assertThat(migrate.status, is("OK"));
		assertThat(migrate.migrationsApplied, hasSize(2));
		assertThat(migrate.migrationsApplied.get(0).fromVersion, is("1"));
		assertThat(migrate.migrationsApplied.get(0).toVersion, is("1"));
	}

}
