# ============================================================================
# RDK MANAGEMENT, LLC CONFIDENTIAL AND PROPRIETARY
# ============================================================================
# This file (and its contents) are the intellectual property of RDK Management, LLC.
# It may not be used, copied, distributed or otherwise  disclosed in whole or in
# part without the express written permission of RDK Management, LLC.
# ============================================================================
# Copyright (c) 2016 RDK Management, LLC. All rights reserved.
# ============================================================================

SUMMARY = "Closedcaption HAL definition"
SECTION = "console/utils"
LICENSE = "CableLabs & RDK"
LIC_FILES_CHKSUM = "file://ccManager/ccregisterforlog.h;endline=11;md5=06b9cc74cd786e4b5b10118eb9a5a57d"
PV = "${RDK_RELEASE}+git${SRCPV}"

PV ?= "1.0.0"
PR ?= "r0"
ALLOW_EMPTY_${PN} = "1"

SRCREV = "9f70b3cde96ee504479120cc4192b6da28f7725f"
SRC_URI = "${RDK_GENERIC_ROOT_GIT}/closedcaption/generic;protocol=${RDK_GIT_PROTOCOL};branch=${RDK_GIT_BRANCH}"
S = "${WORKDIR}/git"
inherit allarch

# this is a HAL package only, nothing to build
do_compile[noexec] = "1"
do_configure[noexec] = "1"

# also get rid of the default dependency added in bitbake.conf
# since there is no 'main' package generated (empty)
RDEPENDS_${PN}-dev = ""

do_install() {
        install -d ${D}${includedir}/closedcaption/ccManager
        install -d ${D}${includedir}/closedcaption/ccGraphics
        install ${S}/ccManager/utils/*.h ${D}${includedir}/closedcaption/ccManager
        install ${S}/ccManager/*.h ${D}${includedir}/closedcaption/ccManager
        install ${S}/ccGraphics/*.h ${D}${includedir}/closedcaption/ccGraphics
        install ${S}/ccGraphics/include/*.h ${D}${includedir}/closedcaption/ccGraphics
        install ${S}/include/*.h ${D}${includedir}/closedcaption
}
