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
package org.sonar.css.tree.impl.scss;

import com.google.common.collect.Iterators;
import org.sonar.css.tree.impl.TreeImpl;
import org.sonar.plugins.css.api.tree.Tree;
import org.sonar.plugins.css.api.tree.css.SyntaxToken;
import org.sonar.plugins.css.api.tree.scss.ScssParentSelectorTree;
import org.sonar.plugins.css.api.visitors.DoubleDispatchVisitor;

import java.util.Iterator;

public class ScssParentSelectorTreeImpl extends TreeImpl implements ScssParentSelectorTree {

  private SyntaxToken parentSelector;

  public ScssParentSelectorTreeImpl(SyntaxToken parentSelector) {
    this.parentSelector = parentSelector;
  }

  @Override
  public Kind getKind() {
    return Kind.SCSS_PARENT_SELECTOR;
  }

  @Override
  public Iterator<Tree> childrenIterator() {
    return Iterators.singletonIterator(parentSelector);
  }

  @Override
  public void accept(DoubleDispatchVisitor visitor) {
    visitor.visitScssParentSelector(this);
  }

  @Override
  public SyntaxToken parentSelector() {
    return parentSelector;
  }

}