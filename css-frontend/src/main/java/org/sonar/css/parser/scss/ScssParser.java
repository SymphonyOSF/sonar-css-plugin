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
package org.sonar.css.parser.scss;

import com.google.common.annotations.VisibleForTesting;
import com.sonar.sslr.api.typed.ActionParser;
import org.sonar.css.parser.AbstractParser;
import org.sonar.css.parser.LexicalGrammar;
import org.sonar.css.parser.TreeFactory;
import org.sonar.plugins.css.api.tree.Tree;
import org.sonar.sslr.grammar.GrammarRuleKey;
import org.sonar.sslr.grammar.LexerlessGrammarBuilder;

import java.nio.charset.Charset;

public class ScssParser extends AbstractParser {

  private ScssParser(Charset charset, LexerlessGrammarBuilder grammarBuilder, Class<ScssGrammar> scssGrammarClass,
                     TreeFactory treeFactory, ScssNodeBuilder scssNodeBuilder, GrammarRuleKey rootRule) {
    super(charset, grammarBuilder, scssGrammarClass, treeFactory, scssNodeBuilder, rootRule);
  }

  public static ActionParser<Tree> createParser(Charset charset) {
    return createParser(charset, LexicalGrammar.STYLESHEET);
  }

  @VisibleForTesting
  public static ActionParser<Tree> createTestParser(Charset charset, GrammarRuleKey rootRule) {
    return createParser(charset, rootRule);
  }

  private static ActionParser<Tree> createParser(Charset charset, GrammarRuleKey rootRule) {
    return new ScssParser(
      charset,
      LexicalGrammar.createScssGrammar(),
      ScssGrammar.class,
      new TreeFactory(),
      new ScssNodeBuilder(),
      rootRule);
  }

}
