/* -*- tab-width: 4 -*-
 *
 * Electric(tm) VLSI Design System
 *
 * File: J3DKeyCollision.java
 * Written by Gilda Garreton, Sun Microsystems.
 *
 * Copyright (c) 2005 Sun Microsystems and Static Free Software
 *
 * Electric(tm) is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * Electric(tm) is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Electric(tm); see the file COPYING.  If not, write to
 * the Free Software Foundation, Inc., 59 Temple Place, Suite 330,
 * Boston, Mass 02111-1307, USA.
 */

package com.sun.electric.plugins.j3d;

import javax.media.j3d.*;

/** Inspired in example found in Daniel Selman's book "Java 3D Programming"
 * For more information about the original example, contact Daniel Selman: daniel@selman.org
 * Free Software Foundation, Inc.,
 * 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 * @author  Gilda Garreton
 * @version 0.1
*/

public class J3DKeyCollision extends J3DKeyBehavior
{
	private View3DWindow collisionChecker;


	public J3DKeyCollision(TransformGroup tg, View3DWindow collisionDetector)
	{
		super(tg);

        tGroup = tg;
        transform = new Transform3D( );
		collisionChecker = collisionDetector;
	}

    /**
     * Method to apply given transformation
     * @return true if there was no collision
     */
	protected boolean updateTransform(boolean force)
	{
        boolean collision = false;
        if (!force)
            collision = collisionChecker.isCollision(transform);
		if( collision == false )
			tGroup.setTransform(transform);
        return !collision;
	}
}