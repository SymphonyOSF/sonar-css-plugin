/*
 * SonarQube CSS / SCSS / Less Analyzer
 * Copyright (C) 2013-2016 Tamas Kende and David RACODON
 * mailto: kende.tamas@gmail.com and david.racodon@gmail.com
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */
package org.sonar.css.checks.css;

import org.junit.Test;
import org.sonar.css.checks.CheckTestUtils;
import org.sonar.css.checks.verifier.CssCheckVerifier;

import static org.fest.assertions.Assertions.assertThat;

public class CssVariableNamingConventionCheckTest {

  private final CssVariableNamingConventionCheck check = new CssVariableNamingConventionCheck();

  @Test
  public void test_with_default_format() {
    check.setFormat("^[a-z][-a-z0-9]*$");
    CssCheckVerifier.verifyCssFile(check, CheckTestUtils.getCssTestFile("variable-naming-convention/variableNamingConvention.css"));
  }

  @Test
  public void test_with_custom_format() {
    check.setFormat("^[-a-z]+$");
    CssCheckVerifier.verifyCssFile(check, CheckTestUtils.getCssTestFile("variable-naming-convention/variableNamingConventionCustomFormat.css"));
  }

  @Test
  public void should_throw_an_illegal_state_exception_as_the_format_parameter_is_not_valid() {
    try {
      check.setFormat("(");

      CssCheckVerifier.issuesOnCssFile(check, CheckTestUtils.getCssTestFile("variable-naming-convention/variableNamingConvention.css")).noMore();

    } catch (IllegalStateException e) {
      assertThat(e.getMessage()).isEqualTo("Check css:css-variable-naming-convention (CSS variables should follow a naming convention): "
        + "format parameter \"(\" is not a valid regular expression.");
    }
  }

}
