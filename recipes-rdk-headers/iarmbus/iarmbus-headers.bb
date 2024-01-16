# ============================================================================
# RDK MANAGEMENT, LLC CONFIDENTIAL AND PROPRIETARY
# ============================================================================
# This file (and its contents) are the intellectual property of RDK Management, LLC.
# It may not be used, copied, distributed or otherwise  disclosed in whole or in
# part without the express written permission of RDK Management, LLC.
# ============================================================================
# Copyright (c) 2016 RDK Management, LLC. All rights reserved.
# ============================================================================

# Version and SRCREV for this component is handled in conf/include/rdk-headers-versions.inc

# Please note that this header file recipe is added as temporary
# fix to provide iarmbus headers needed for power and deepsleep manager
# should be removed once the new implementation based on RDKCentral headers
# is available in RDKE Vendor and Middleware layers

SUMMARY = "iarmbus headers"
SECTION = "console/utils"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=175792518e4ac015ab6696d16c4f607e"

ALLOW_EMPTY_${PN} = "1"

SRC_URI = "${RDKE_GITHUB_ROOT}/iarmbus;${RDKE_GITHUB_SRC_URI_SUFFIX};name=iarmbus"

S = "${WORKDIR}/git"

inherit allarch

# this is a HAL package only, nothing to build
do_compile[noexec] = "1"
do_configure[noexec] = "1"

# also get rid of the default dependency added in bitbake.conf
# since there is no 'main' package generated (empty)
RDEPENDS_${PN}-dev = ""

do_install() {
        install -d ${D}${includedir}/rdk/iarmbus
        install -m 0644 ${S}/core/include/*.h ${D}${includedir}/rdk/iarmbus
}
