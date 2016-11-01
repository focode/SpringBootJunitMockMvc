package com.algo.done;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.Resource;

@WebAppConfiguration
@RunWith( SpringJUnit4ClassRunner.class )
@Category( IntegrationTest.class )
@SpringApplicationConfiguration( classes = {AlgoApplication.class } )
@TestExecutionListeners( { DependencyInjectionTestExecutionListener.class, TransactionalTestExecutionListener.class } )
public abstract class BaseIntegrationTest
    extends AbstractJUnit4SpringContextTests
{

    protected final Logger LOG = LogManager.getLogger( getClass() );

    @Resource
    private WebApplicationContext wac;

    protected MockMvc mockMvc;

    @Before
    public void setUp()
    {
        this.mockMvc = MockMvcBuilders.webAppContextSetup( this.wac ).build();
    }

    @After
    public void tearDown()
    {
    }
}
