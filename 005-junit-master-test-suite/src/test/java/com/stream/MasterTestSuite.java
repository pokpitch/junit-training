package com.stream;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(value = Suite.class)
@SuiteClasses(value = { TestSuiteA.class, TestSuiteB.class })
public class MasterTestSuite {}
