SUMMARY = "Soc-specific implementations for video applications"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"

ALLOW_EMPTY:${PN} = "1"

PV = "${@bb.utils.contains('DISTRO_FEATURES', 'RDKE_PLATFORM_STB', "1.0.0", "2.0.0", d)}"
SRCREV = "${@bb.utils.contains('DISTRO_FEATURES', 'RDKE_PLATFORM_STB', "ceb1e846dc1c959dae401db6036bd133fecc9d52", "f6e7e0c0e09e67785d0c59531719b970bbe32c86", d)}"

SRC_URI = "${CMF_GITHUB_ROOT}/gstreamer-netflix-platform;${CMF_GITHUB_SRC_URI_SUFFIX}"

S = "${WORKDIR}/git"
inherit allarch

# this is a HAL package only, nothing to build
do_compile[noexec] = "1"
do_configure[noexec] = "1"

# also get rid of the default dependency added in bitbake.conf
# since there is no 'main' package generated (empty)
RDEPENDS:${PN}-dev = ""

do_install() {
        install -d ${D}${includedir}
        install -m 0644 ${S}/rdk_gstreamer_utils.h  ${D}${includedir}/
        install -m 0644 ${S}/rdk_gstreamer_utils_soc.h ${D}${includedir}/
}
