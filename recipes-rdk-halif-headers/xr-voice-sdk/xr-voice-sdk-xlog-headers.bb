# Version and SRCREV for this component is handled in conf/include/rdk-headers-versions.inc

SUMMARY = "This recipe provides RDK XR Voice SDK XLOG Interface headers"
SECTION = "console/utils"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=175792518e4ac015ab6696d16c4f607e"

ALLOW_EMPTY:${PN} = "1"

SRC_URI = "${CMF_GITHUB_ROOT}/xr-voice-sdk;${CMF_GITHUB_SRC_URI_SUFFIX};name=xr-voice-sdk-xlog-headers"

S = "${WORKDIR}/git"

inherit allarch
inherit python3native

# this is a HAL package only
do_configure[noexec] = "1"

# also get rid of the default dependency added in bitbake.conf
# since there is no 'main' package generated (empty)
RDEPENDS:${PN}-dev = ""

do_compile() {
    ${STAGING_BINDIR_NATIVE}/python3-native/python3 ${S}/scripts/rdkx_logger_modules_to_c.py ${S}/src/xr-logger/rdkv/rdkx_logger_modules.json rdkx_logger_modules
}

do_install() {
    install -d ${D}${includedir}
    install -m 644 ${S}/src/xr-logger/rdkx_logger.h ${D}${includedir}
    install -m 644 ${S}/rdkx_logger_modules.h ${D}${includedir}
}