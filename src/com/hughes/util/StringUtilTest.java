// Copyright 2011 Google Inc. All Rights Reserved.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.hughes.util;

import java.util.regex.Pattern;

import junit.framework.TestCase;

public class StringUtilTest extends TestCase {
  
  public void testRemove() {
    StringBuilder sb;
    
    sb = new StringBuilder("a<!--asdfasdf-->b<!---> -->c<!---->d");
    assertEquals("<!--asdfasdf-->", StringUtil.remove(sb, Pattern.compile("<!--", Pattern.LITERAL), Pattern.compile("-->", Pattern.LITERAL), true));
    assertEquals("ab<!---> -->c<!---->d", sb.toString());

    assertEquals("<!---> -->", StringUtil.remove(sb, Pattern.compile("<!--", Pattern.LITERAL), Pattern.compile("-->", Pattern.LITERAL), true));
    assertEquals("<!---->", StringUtil.remove(sb, Pattern.compile("<!--", Pattern.LITERAL), Pattern.compile("-->", Pattern.LITERAL), true));

    sb = new StringBuilder("a<!--asdfasdf-->b<!---> -->c<!---->d");
    assertEquals("abcd", StringUtil.removeAll(sb, Pattern.compile("<!--", Pattern.LITERAL), Pattern.compile("-->", Pattern.LITERAL)).toString());

  }

}
