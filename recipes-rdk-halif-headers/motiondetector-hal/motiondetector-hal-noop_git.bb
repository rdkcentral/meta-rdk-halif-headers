# ============================================================================
# RDK MANAGEMENT, LLC CONFIDENTIAL AND PROPRIETARY
# ============================================================================
# This file (and its contents) are the intellectual property of RDK Management, LLC.
# It may not be used, copied, distributed or otherwise  disclosed in whole or in
# part without the express written permission of RDK Management, LLC.
# ============================================================================
# Copyright (c) 2016 RDK Management, LLC. All rights reserved.
# ============================================================================

SUMMARY = "Motion Detector HAL llama"
SECTION = "console/utils"

LICENSE = "CLOSED"

PROVIDES += "virtual/vendor-motiondetector-hal"
RPROVIDES:${PN} = "virtual/vendor-motiondetector-hal"

SRC_URI = "${RDKE_GITHUB_ROOT}/motiondetector-hal-stubs;${RDKE_GITHUB_SRC_URI_SUFFIX}"
SRCREV = "0e63ee1a7c49223fbd009c9ea62596c3cd873773"

S = "${WORKDIR}/git"



ASNEEDED = ""

CFLAGS += "-fPIC -D_REENTRANT -Wall ${INCLUDE_DIRS} ${DBUS_LIB_DIR}"

# a HAL is machine specific
PACKAGE_ARCH = "${MIDDLEWARE_ARCH}"

# Shared libs created by the RDK build aren't versioned, so we need
# to force the .so files into the runtime package (and keep them
# out of -dev package).
FILES_SOLIBSDEV = ""
FILES:${PN} += "${libdir}/*.so"

TARGET_CC_ARCH += "${LDFLAGS}"

do_compile() {
        oe_runmake -C ${S}/
}

do_install() {

    # Install our HAL .h files required by the 'generic' devicesettings
    install -d ${D}${includedir}/
    install -m 0644 ${S}/*.h ${D}${includedir}/
    install -d ${D}${libdir}
    install -m 0755 ${S}/libmd-hal.so ${D}${libdir}/libmd-hal.so
    ln -s libmd-hal.so ${D}${libdir}/libmd-hal.so.0
    ln -s libmd-hal.so ${D}${libdir}/libmdhal.so
}
INSANE_SKIP:${PN} += "dev-so"
FILES:${PN} += "/usr/lib/libmd-hal.so /usr/lib/libmdhal.so"
