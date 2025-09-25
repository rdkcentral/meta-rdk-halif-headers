SUMMARY = "Middleware Player SOC Interface Headers"
DESCRIPTION = "This layer provides Middleware Player SOC Interface Headers"
LICENSE = "CLOSED"

ALLOW_EMPTY:${PN} = "1"

SRC_URI = "${CMF_GITHUB_ROOT}/middleware-player-interface.git;${CMF_GITHUB_SRC_URI_SUFFIX}"
SRCREV = "${AUTOREV}"

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
        install -m 0644 ${S}/vendor/PlayerSocInterfaceImpl.h  ${D}${includedir}/
}
