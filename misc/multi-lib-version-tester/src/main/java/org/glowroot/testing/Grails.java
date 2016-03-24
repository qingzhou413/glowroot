/**
 * Copyright 2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.glowroot.testing;

public class Grails {

    private static String MODULE_PATH = "agent-parent/plugins/grails-plugin";

    public static void main(String[] args) throws Exception {
        for (int i = 0; i <= 4; i++) {
            if (i == 1) {
                // there is no 3.1.1 in maven central
                continue;
            }
            run("3.1." + i);
        }
    }

    private static void run(String version) throws Exception {
        Util.updateLibVersion(MODULE_PATH, "grails.version", version);
        Util.runTests(MODULE_PATH);
    }
}