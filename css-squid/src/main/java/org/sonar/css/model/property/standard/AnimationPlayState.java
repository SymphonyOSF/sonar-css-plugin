/*
 * SonarQube CSS Plugin
 * Copyright (C) 2013 Tamas Kende and David RACODON
 * kende.tamas@gmail.com
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
 * You should have received a copy of the GNU Lesser General Public
 * License along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02
 */
package org.sonar.css.model.property.standard;

import org.sonar.css.model.Vendor;
import org.sonar.css.model.property.StandardProperty;
import org.sonar.css.model.property.validator.property.animation.AnimationPlayStateValidator;

public class AnimationPlayState extends StandardProperty {

  public AnimationPlayState() {
    addLinks("http://dev.w3.org/csswg/css-animations/#propdef-animation-play-state");
    addVendors(Vendor.WEBKIT, Vendor.MOZILLA);
    addValidators(new AnimationPlayStateValidator());
  }

}